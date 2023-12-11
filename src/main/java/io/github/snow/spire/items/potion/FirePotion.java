package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class FirePotion extends CommonPotion {
    public FirePotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "火焰药水";
    }

    @Override
    public String getDescription() {
        return "造成 20 点伤害。";
    }
}
