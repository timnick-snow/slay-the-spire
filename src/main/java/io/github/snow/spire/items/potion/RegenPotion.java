package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class RegenPotion extends UncommonPotion {
    public RegenPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "再生药水";
    }

    @Override
    public String getDescription() {
        return "获得 5 层 再生 。";
    }
}
