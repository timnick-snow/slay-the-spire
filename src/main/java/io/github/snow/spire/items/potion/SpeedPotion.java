package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class SpeedPotion extends CommonPotion {
    public SpeedPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "速度药水";
    }

    @Override
    public String getDescription() {
        return "获得 5 点 敏捷 。在你的回合结束时，失去 5 点 敏捷 。";
    }
}
