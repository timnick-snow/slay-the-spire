package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class EnergyPotion extends CommonPotion {
    public EnergyPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "能量药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 点能量。";
    }
}
