package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class StrengthPotion extends CommonPotion {
    public StrengthPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "力量药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 点 力量 。";
    }
}
