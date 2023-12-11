package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class DexterityPotion extends CommonPotion {
    public DexterityPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "敏捷药水";
    }

    @Override
    public String getDescription() {
        return "获得 2 点 敏捷 。";
    }
}
