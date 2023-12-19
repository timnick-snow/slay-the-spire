package io.github.snow.spire.items.reward;

import io.github.snow.spire.game.RunSupport;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/19
 */
@RequiredArgsConstructor
public class GoldReward implements Reward {

    private final int amount;

    @Override
    public String display() {
        return "金币 × " + amount;
    }

    @Override
    public boolean take(RunSupport runSupport) {
        runSupport.addGold(amount);
        return true;
    }
}
