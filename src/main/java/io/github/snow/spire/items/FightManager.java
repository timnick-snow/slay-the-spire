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

import java.util.List;
import java.util.Random;

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
        【机甲战士】 hp: 70/70    effect: 0  |  【邪教徒 e1】 hp: 40/40    effect: 0  意图：强化
                                           |
        ---------------------------------------------------------------------------------------------------
        你的手牌：5    剩余能量：3

             0              1               2              3              4
        【2E - 痛击】    【1E - 打击】    【1E - 打击】    【1E - 打击】    【1E - 打击】

        【1E - 防御】    【1E - 防御】    【1E - 防御】    【1E - 防御】    【1E - 防御】
             5              6               7              8              9

        ---------------------------------------------------------------------------------------------------
        弃牌堆：0    消耗堆：0
        ---------------------------------------------------------------------------------------------------
         */
        Player player = ctx.getPlayer();
        List<Enemy> enemies = ctx.getEnemies();

        String divider = "-".repeat(120) + "\n";
        StringBuilder buf = new StringBuilder();
        buf.append("\n").append(divider);

        // 单位区
        buf.append(left(kw(player.displayName()), 18));
        String playerInfo = "  hp: %2d/%2d    effect: %d  |".formatted(player.hp(), player.maxHp(), player.powers().size());
        buf.append(playerInfo);
        int leftPadding = strWidth(playerInfo) + 18 - 1;
        for (Enemy enemy : enemies) {
            buf.append("  ").append(left(kw(enemy.displayName()), 18));
            buf.append(" hp: %d/%d    effect: %d  意图：%s".formatted(enemy.hp(), enemy.maxHp(), enemy.powers().size(), "强化"));
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
            buf.append("        {{ 当前没有任何手牌 }}        \n");
        } else {
            StringBuilder numBuf = new StringBuilder();
            StringBuilder cardBuf = new StringBuilder();
            for (int i = 0; i < 5 && i < hand.size(); i++) {
                buildHandSegment(hand, numBuf, cardBuf, i);
            }
            buf.append(numBuf).append("\n")
                    .append(cardBuf).append("\n\n");

            if (hand.size() > 5) {
                numBuf = new StringBuilder();
                cardBuf = new StringBuilder();
                for (int i = 5; i < 10 && i < hand.size(); i++) {
                    buildHandSegment(hand, numBuf, cardBuf, i);
                }
                buf.append(cardBuf).append("\n")
                        .append(numBuf).append("\n\n");
            }
        }
        buf.append(divider);

        // 其它区
        buf.append("弃牌堆：").append(ctx.getDiscardPile().size()).append("    ")
                .append("消耗堆：").append(ctx.getExhaustPile().size())
                .append("\n");
        buf.append(divider);

        System.out.println(buf);
    }

    private void buildHandSegment(List<FightCard> hand, StringBuilder numBuf, StringBuilder cardBuf, int i) {
        int offset = 5;
        Card card = hand.get(i).card();
        numBuf.append(" ".repeat(offset)).append(i);

        String cardInfo = "【%sE - %s】".formatted(card.costDisplay(), card.displayName());
        cardBuf.append(cardInfo).append("    ");
        numBuf.append(" ".repeat(strWidth(cardInfo) + 4 - 6));
    }

    public void enemyRoundStart(FightContext ctx) {
        System.out.printf("【第 %d 回合】 - 敌方回合阶段\n", ctx.getRound());
        ctx.getEnemies().forEach(enemy -> enemy.onRoundStart(ctx));

        // todo 意图处理
    }


    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.fightRandom1 = source.getRandomManage().getFightRandom1();
        this.fightRandom2 = source.getRandomManage().getFightRandom2();
        this.fightRandom3 = source.getRandomManage().getFightRandom3();
    }
}
