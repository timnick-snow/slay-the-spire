package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class BlockPotion extends CommonPotion {
    public BlockPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "格挡药水";
    }

    @Override
    public String getDescription() {
        return "获得 12 点 格挡 。";
    }
}
