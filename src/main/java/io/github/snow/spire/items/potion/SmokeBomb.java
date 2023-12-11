package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class SmokeBomb extends RarePotion {
    public SmokeBomb(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "烟雾弹";
    }

    @Override
    public String getDescription() {
        return "从一场非Boss战斗中逃离，不获得任何奖励。";
    }
}
