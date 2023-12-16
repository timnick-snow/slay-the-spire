package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.Player;
import io.github.snow.spire.temp.RunContext;
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

/*
战斗开始 -> 第X回合开始 -> 玩家回合开始 -> 玩家回合结束 -> 敌人回合开始 -> 敌人回合结束 ->  第X回合结束
 */

    /**
     * 开始战斗
     */
    public void startFight(FightContext ctx) {
        // 战斗开始
        System.out.println("战斗开始！");
        ctx.getPlayer().onFightStart(ctx);
        ctx.shuffle();

        // 回合开始
        playerRoundStart(ctx);
    }

    /*
    玩家回合开始 -> 抽牌 -> 打牌 -> 玩家回合结束
     */
    public void playerRoundStart(FightContext ctx) {
        int round = ctx.roundAdd();
        System.out.printf("【第 %d 回合】 - 玩家回合阶段\n", round);
        ctx.getPlayer().onRoundStart(ctx);

        // 抽牌 todo 实际抽牌数受到遗物/能力的影响  抽到牌时的生命周期
        ValueWrapper drawNum = ValueWrapper.of(5);
        List<FightCard> draw = ctx.draw(drawNum.getValue());
        // 重置能量 todo 实际能量数受到遗物/能力的影响
        ValueWrapper energyNum = ValueWrapper.of(3);
        ctx.setEnergy(energyNum.getValue());

        // 当前战斗内概述信息
        overview(ctx);
    }

    public void overview(FightContext ctx) {
        /*
        ---------------------------------------------------------------------------------------------------
        【机甲战士】 hp: 70/70    power: 0  |  【邪教徒 e1】 hp: 40/40    power: 0  意图：强化
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

        String divider = "-".repeat(120) + "\n";
        StringBuilder buf = new StringBuilder();
        buf.append("\n").append(divider);

        // 回合指示
        buf.append(" ".repeat(20)).append("第      ").append(ctx.getRound()).append("      回      合\n");
        buf.append(divider);
        // 单位区
        buf.append(left(kw(player.displayName()), 18));
        String playerInfo = "  hp: %2d/%2d    power: %d  |".formatted(player.hp(), player.maxHp(), player.powers().size());
        buf.append(playerInfo);
        int leftPadding = strWidth(playerInfo) + 18 - 1;
        for (Enemy enemy : enemies) {
            buf.append("  ").append(left(kw(enemy.displayName()), 18));
            buf.append(" hp: %d/%d    power: %d  意图：%s".formatted(enemy.hp(), enemy.maxHp(), enemy.powers().size(), "强化"));
            buf.append("\n");
            buf.append(" ".repeat(leftPadding)).append("|");
        }
        buf.append("\n").append(divider);

        // 手牌区
        List<FightCard> hand = ctx.getHand();
        buf.append("你的手牌：").append(hand.size()).append("    ")
                .append("剩余能量：").append(ctx.getEnergy())
                .append("\n\n");
        if (hand.isEmpty()) {
            buf.append("        {{ 空空如也 }}        \n");
        } else {
            buf.append(pileFormat(hand, false));
        }
        buf.append(divider);

        // 其它区
        buf.append("抽牌堆：").append(ctx.getDrawPile().size()).append("    ")
                .append("弃牌堆：").append(ctx.getDiscardPile().size()).append("    ")
                .append("消耗堆：").append(ctx.getExhaustPile().size())
                .append("\n");
        buf.append(divider);

        System.out.println(buf);
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

    public void enemyRoundStart(FightContext ctx) {
        System.out.printf("【第 %d 回合】 - 敌方回合阶段\n", ctx.getRound());
        ctx.getEnemies().forEach(enemy -> enemy.onRoundStart(ctx));

        // todo 意图处理
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
        System.out.println(res);
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