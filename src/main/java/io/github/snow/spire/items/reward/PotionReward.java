package io.github.snow.spire.items.reward;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.potion.Potion;
import lombok.RequiredArgsConstructor;

/**
 * 药水奖励
 *
 * @author snow
 * @since 2023/12/11
 */
@RequiredArgsConstructor
public class PotionReward implements Reward {

    private final Potion potion;

    @Override
    public String display() {
        return potion.getName();
    }

    @Override
    public String verboseDisplay() {
        return "%s：%s".formatted(potion.getName(), potion.getDescription());
    }

    @Override
    public void take(RunSupport runSupport) {
        runSupport.addPotion(potion);
    }
}
