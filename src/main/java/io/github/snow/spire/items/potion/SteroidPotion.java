package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class SteroidPotion extends CommonPotion {
    public SteroidPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "类固醇药水";
    }

    @Override
    public String getDescription() {
        return "获得 5 点 力量 。在你的回合结束时，失去 5 点 力量 。";
    }
}
