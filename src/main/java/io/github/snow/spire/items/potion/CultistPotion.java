package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class CultistPotion extends RarePotion {
    public CultistPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "邪教徒药水";
    }

    @Override
    public String getDescription() {
        return "获得 1 层 仪式 。";
    }
}
