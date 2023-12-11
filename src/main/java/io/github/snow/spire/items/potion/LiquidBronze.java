package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class LiquidBronze extends UncommonPotion {
    public LiquidBronze(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "流动铜液";
    }

    @Override
    public String getDescription() {
        return "获得 3 点 荆棘 。";
    }
}
