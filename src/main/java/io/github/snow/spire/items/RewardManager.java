package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.potion.Potion;
import io.github.snow.spire.items.reward.CardReward;
import io.github.snow.spire.items.reward.GoldReward;
import io.github.snow.spire.items.reward.PotionReward;
import io.github.snow.spire.items.reward.Reward;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/11
 */
@Component
@RequiredArgsConstructor
public class RewardManager {

    private final CardManager cardManager;
    private final PotionManager potionManager;

    private RunSupport runSupport;
    private Random rewardRandom;
    private int potionOdds = 400;
    private static final int[] GOLD_REWARD = {10, 25, 95};

    /**
     * 战斗胜利奖励
     */
    public List<Reward> fightReward(CombatType combatType) {
        List<Reward> res = new ArrayList<>();

        // 卡牌
        CardColor color = runSupport.getRunContext().getCharacter().color();
        List<Card> cards = cardManager.rewardCard(card -> card.color() == color, combatType);
        res.add(new CardReward(cards));

        // 金币
        int goldBase = switch (combatType) {
            case NORMAL -> GOLD_REWARD[0];
            case ELITE -> GOLD_REWARD[1];
            case BOSS -> GOLD_REWARD[2];
        };
        int goldAdd = rewardRandom.nextInt(0, 11);
        res.add(new GoldReward(goldBase + goldAdd));

        // 药水
        if (rewardRandom.nextInt(0, 1000) < potionOdds) {
            List<Potion> potion = potionManager.getPotion(1);
            res.add(new PotionReward(potion.getFirst()));
            potionOdds -= 100;
        } else {
            potionOdds += 100;
        }

        // 遗物 todo

        return res;
    }


    public String format(List<Reward> rewards, boolean verbose) {
        StringBuilder buf = new StringBuilder();
        buf.append("请领取你的奖励！\n");
        for (int i = 0; i < rewards.size(); i++) {
            buf.append("  ").append(i + 1).append(" ====> ");
            if (verbose) {
                buf.append(rewards.get(i).verboseDisplay());
            } else {
                buf.append(rewards.get(i).display());
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        this.runSupport = (RunSupport) event.getSource();
        this.rewardRandom = runSupport.getRunContext().getRandomManage().getOtherRandom();
    }
}
