package io.github.snow.spire.items.reward;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.card.Card;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
@RequiredArgsConstructor
public class CardReward implements Reward {
    private final List<Card> cards;

    @Override
    public String display() {
        return "选择一张卡加入你的卡组。";
    }

    @Override
    public boolean take(RunSupport runSupport) {
        return runSupport.chooseCard(cards);
    }
}
