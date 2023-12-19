package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.beans.pojo.PlayRule;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.intent.Intent;
import io.github.snow.spire.items.player.Player;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Output;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.*;

import static io.github.snow.spire.tool.FormatUtil.*;

/**
 * @author snow
 * @since 2023/12/15
 */
@Component
public class FightManager {

    /**
     * 战斗随机数 - 战斗内的随机数1 - 己方
     */
    private Random fightRandom1;
    /**
     * 战斗随机数 - 战斗内的随机数2 - 敌方
     */
    private Random fightRandom2;
    /**
     * 战斗随机数 - 战斗内的随机数3 - 其它
     */
    private Random fightRandom3;

    final static String DIVIDER = "-".repeat(140) + "\n";

/*
战斗开始 -> 第X回合开始 -> 玩家回合开始 -> 玩家回合结束 -> 敌人回合开始 -> 敌人回合结束 ->  第X回合结束
 */

    /**
     * 开始战斗
     */
    public void startFight(FightContext ctx) {
        // 战斗开始
        Output.println("战斗开始！");
        ctx.getPlayer().onFightStart(ctx);
        ctx.shuffle();

        // 回合开始
        playerRoundStart(ctx);
    }

    /**
     * 玩家回合开始 -> 抽牌 -> 打牌 -> 玩家回合结束
     */
    public void playerRoundStart(FightContext ctx) {
        int round = ctx.roundAdd();
        Output.printf("\n【第 %d 回合】 - 玩家回合阶段\n", round);
        ctx.getPlayer().onRoundStart(ctx);

        // 1. 抽牌
        ValueWrapper drawNum = ValueWrapper.of(5);
        List<FightCard> draw = ctx.draw(drawNum.getValue());
        // 2. 重置能量
        ValueWrapper energyNum = ValueWrapper.of(3);
        ctx.setEnergy(energyNum.getValue());
        // 3. 当前战斗内概述信息 => 等待玩家打牌
        overview(ctx);
    }

    /**
     * 打出卡牌
     */
    public void playCard(FightCard card, PlayRule playRule, FightContext ctx) {
        if (!card.isPlayable(playRule, ctx)) {
            // 0. 卡牌不可打出
            return;
        }
        // 1. 获取卡牌效果
        List<RoughEffect<?>> roughEffectList = card.getRoughEffect(ctx.getPlayer());
        List<Effect<?>> effects = new ArrayList<>();
        for (RoughEffect<?> roughEffect : roughEffectList) {
            EffectTarget effectTarget = roughEffect.effectTarget();
            List<DisplayAble> targets = new ArrayList<>();
            switch (effectTarget) {
                case NONE -> {
                }
                case SELF -> targets.add(ctx.getPlayer());
                case SINGLE_OPPONENT -> {
                    if (playRule.getMaster() != null && playRule.getMaster() instanceof Enemy enemy) {
                        targets.add(enemy);
                    } else if (playRule.getMaster() == null && ctx.getEnemies().size() == 1) {
                        targets.add(ctx.getEnemies().getFirst());
                    } else {
                        Output.println("你需要指定一个敌方目标");
                        return;
                    }
                }
                case ALL_OPPONENT -> targets.addAll(ctx.getEnemies());
                case RANDOM_OPPONENT -> targets.add(ctx.getEnemies().getFirst());
            }
            effects.add(roughEffect.process(targets));
        }

        // 2. 打出消耗能量
        Output.printf("你打出卡牌 【%s】\n", card.displayName());
        ctx.consumeEnergy(card.cost());
        ctx.moveCard(card, CardPosition.PLAY_ZONE);

        // 3. 执行卡牌效果
        effects.forEach(effect -> effect.work(ctx));

        // 4. 卡牌使用完成进入弃牌堆
        ctx.moveCard(card, CardPosition.DISCARD_PILE);

        // 5. 剩余手牌
        Output.println("done.\n");
        Output.println(handFormat(ctx));
    }

    /**
     * 结束玩家回合
     */
    public void endPlayerRound(FightContext ctx) {
        // 1. 剩余手牌的去向
        List<FightCard> handCopy = new ArrayList<>(ctx.getHand());
        List<FightCard> discard = new ArrayList<>();
        for (FightCard card : handCopy) {
            CardPosition position = card.positionOnEnd();
            if (position == CardPosition.DISCARD_PILE) {
                discard.add(card);
            }
            ctx.moveCard(card, position);
        }
        if (!discard.isEmpty()) {
            StringBuilder buf = new StringBuilder();
            buf.append("手牌中的 %d 张卡牌进入弃牌堆：".formatted(discard.size()));
            for (FightCard card : discard) {
                buf.append(kw(card.displayName())).append("  ");
            }
            Output.println(buf.toString());
        }

        // 2. 敌方回合开始
        enemyRoundStart(ctx);
    }

    /**
     * 敌方回合开始
     */
    public void enemyRoundStart(FightContext ctx) {
        int round2 = ctx.round2Add();
        Output.printf("\n【第 %d 回合】 - 敌方回合阶段\n", round2);
        ctx.getEnemies().forEach(enemy -> enemy.onRoundStart(ctx));

        // 1. 获取意图的效果 执行效果
        for (Enemy enemy : ctx.getEnemies()) {
            Output.printf("【%s】开始行动\n", enemy.displayName());
            Intent intent = enemy.intent(ctx);
            List<RoughEffect<?>> roughEffects = intent.getRoughEffect(enemy);
            for (RoughEffect<?> roughEffect : roughEffects) {
                EffectTarget effectTarget = roughEffect.effectTarget();
                List<Fighter> targets = new ArrayList<>();
                switch (effectTarget) {
                    case SELF -> targets.add(enemy);
                    case SINGLE_OPPONENT -> targets.add(ctx.getPlayer());
                    default -> {
                    }
                }
                roughEffect.process(targets).work(ctx);
            }
        }

        // 2. 敌军回合结束
        ctx.getEnemies().forEach(enemy -> enemy.onRoundEnd(ctx));

        // 3. 玩家下一回开始
        playerRoundStart(ctx);
    }

    public void overview(FightContext ctx) {
        /*
        ---------------------------------------------------------------------------------------------------
        【机甲战士】 hp: 70/70  block: 0  power: 0  |  【邪教徒 e1】 hp: 40/40  block: 0  power: 0  意图：攻势(6*6) + 强化 + 其它
                                                   |
        ---------------------------------------------------------------------------------------------------
        你的手牌：5    剩余能量：3

             0              1               2              3              4
        【2E - 痛击】    【1E - 打击】    【1E - 打击】    【1E - 打击】    【1E - 打击】

        【1E - 防御】    【1E - 防御】    【1E - 防御】    【1E - 防御】    【1E - 防御】
             5              6               7              8              9

        ---------------------------------------------------------------------------------------------------
        抽牌堆：0    弃牌堆：0    消耗堆：0
        ---------------------------------------------------------------------------------------------------
         */
        Player player = ctx.getPlayer();
        List<Enemy> enemies = ctx.getEnemies();

        StringBuilder buf = new StringBuilder();
        buf.append("\n").append(DIVIDER);

        // 回合指示
        buf.append(" ".repeat(24)).append("第      ").append(ctx.getRound()).append("      回      合\n");
        buf.append(DIVIDER);
        // 单位区
        buf.append(left(kw(player.displayName()), 18));
        String playerInfo = "  hp: %2d/%2d  block: %d  power: %d  |".formatted(player.hp(), player.maxHp(), player.block(), player.powers().size());
        buf.append(playerInfo);
        int leftPadding = strWidth(playerInfo) + 18 - 1;
        for (Enemy enemy : enemies) {
            buf.append("  ").append(left(kw(enemy.displayName()), 18));
            buf.append(" hp: %d/%d  block: %d  power: %d  意图：%s".formatted(enemy.hp(), enemy.maxHp(), enemy.block(), enemy.powers().size(), "强化"));
            buf.append("\n");
            buf.append(" ".repeat(leftPadding)).append("|");
        }
        buf.append("\n").append(DIVIDER);

        // 手牌区
        buf.append(handFormat(ctx));
        buf.append(DIVIDER);

        // 其它区
        buf.append("抽牌堆：").append(ctx.getDrawPile().size()).append("    ")
                .append("弃牌堆：").append(ctx.getDiscardPile().size()).append("    ")
                .append("消耗堆：").append(ctx.getExhaustPile().size())
                .append("\n");
        buf.append(DIVIDER);

        Output.println(buf.toString());
    }

    public String handFormat(FightContext ctx) {
        StringBuilder buf = new StringBuilder();
        List<FightCard> hand = ctx.getHand();
        buf.append("你的手牌：").append(hand.size()).append("    ")
                .append("剩余能量：").append(ctx.getEnergy())
                .append("\n\n");
        if (hand.isEmpty()) {
            buf.append("        {{ 空空如也 }}        \n");
        } else {
            buf.append(pileFormat(hand, false));
        }
        return buf.toString();
    }

    public String powerInfo(Fighter fighter) {
        StringBuilder buf = new StringBuilder();
        buf.append(left(kw(fighter.displayName()), 18));
        String playerInfo = "  hp: %2d/%2d  block: %d  power: %d".formatted(fighter.hp(), fighter.maxHp(), fighter.block(), fighter.powers().size());
        buf.append(playerInfo).append("\n");

        // power
        if (!fighter.powers().isEmpty()) {
            buf.append("能力：\n");
            for (Power power : fighter.powers()) {
                // 痛击(3)：xxx
                // 力量(5)：xxx
                buf.append("    ").append(power.displayName())
                        .append("：").append(power.description())
                        .append("\n");
            }
        }
        return buf.toString();
    }

    private void buildHandSegment(List<FightCard> pile, StringBuilder numBuf, StringBuilder cardBuf, int i, boolean showId) {
        int offset = 5;
        Card card = pile.get(i);
        numBuf.append(" ".repeat(offset));
        int numWidth;
        if (showId) {
            numBuf.append(card.id());
            numWidth = strWidth(String.valueOf(card.id()));
        } else {
            numBuf.append(i);
            numWidth = strWidth(String.valueOf(i));
        }

        String cardInfo = "【%sE - %s】".formatted(card.costDisplay(), card.displayName());
        cardBuf.append(cardInfo).append("    ");
        numBuf.append(" ".repeat(strWidth(cardInfo) - numWidth - 1));
    }


    public void drawPile(FightContext fightContext) {
        showPile("抽牌堆", fightContext.getDrawPile());
    }

    public void discardPile(FightContext fightContext) {
        showPile("弃牌堆", fightContext.getDiscardPile());
    }

    public void exhaustPile(FightContext fightContext) {
        showPile("消耗堆", fightContext.getExhaustPile());
    }

    public void showPile(String title, Deque<FightCard> pile) {
        List<FightCard> list = new ArrayList<>(pile);
        list.sort(Comparator.comparing(Card::id));
        String res = """
                %s：%d
                                
                %s
                """.formatted(title, pile.size(), pileFormat(list, true));
        Output.println(res);
    }

/*
d03  【打击+】  <手牌>
耗能: 1E  |  原耗能: 1E  |  颜色：红色  |  类型：攻击  |  稀有度：初始
描述：...
关键字：
    【易伤】：从 攻击 受到的伤害增加 50% 。

关联卡：
    【XXX】：1E | 无色 | 技能 | ...

 */

    public String cardFormat(FightCard fc) {
        StringBuilder buf = new StringBuilder();
        buf.append("""
                %s  【%s】  <%s>
                                
                耗能: %sE  |  原耗能: %sE  |  颜色：%s  |  类型：%s  |  稀有度：%s
                                
                描述：%s
                """
                .formatted(fc.id(), fc.displayName(), fc.position().displayName()
                        , fc.costDisplay(), fc.originCostDisplay(), fc.color().displayName()
                        , fc.type().displayName(), fc.rarity().displayName(), fc.description())
        );
        // todo 关键字 关联卡
        return buf.toString();
    }

    private String pileFormat(List<FightCard> pile, boolean showId) {
        StringBuilder buf = new StringBuilder();
        if (pile.isEmpty()) {
            buf.append("        {{ 空空如也 }}        \n");
            return buf.toString();
        }
        int i = 0;
        while (i < pile.size()) {
            StringBuilder numBuf = new StringBuilder();
            StringBuilder cardBuf = new StringBuilder();
            for (int j = 0; j < 5 && i < pile.size(); j++, i++) {
                buildHandSegment(pile, numBuf, cardBuf, i, showId);
            }
            buf.append(numBuf).append("\n")
                    .append(cardBuf).append("\n\n");

            if (i < pile.size()) {
                numBuf = new StringBuilder();
                cardBuf = new StringBuilder();
                for (int j = 0; j < 5 && i < pile.size(); j++, i++) {
                    buildHandSegment(pile, numBuf, cardBuf, i, showId);
                }
                buf.append(cardBuf).append("\n")
                        .append(numBuf).append("\n\n");
            }
        }
        return buf.toString();
    }


    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.fightRandom1 = source.getRandomManage().getFightRandom1();
        this.fightRandom2 = source.getRandomManage().getFightRandom2();
        this.fightRandom3 = source.getRandomManage().getFightRandom3();
    }
}
