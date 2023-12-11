package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class AncientPotion extends UncommonPotion {
    public AncientPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "先古药水";
    }

    @Override
    public String getDescription() {
        return "获得 1 层 人工制品 。";
    }
}
