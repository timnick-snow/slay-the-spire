package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class WeakPotion extends CommonPotion {
    public WeakPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "虚弱药水";
    }

    @Override
    public String getDescription() {
        return "给予 3 层 虚弱 。";
    }
}
