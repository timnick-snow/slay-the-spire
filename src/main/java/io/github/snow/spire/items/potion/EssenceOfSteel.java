package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class EssenceOfSteel extends UncommonPotion {
    public EssenceOfSteel(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "钢之精华";
    }

    @Override
    public String getDescription() {
        return "获得 4 层 多层护甲 。";
    }
}
