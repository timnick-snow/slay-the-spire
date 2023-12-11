package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class FairyPotion extends RarePotion {
    public FairyPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "瓶中精灵";
    }

    @Override
    public String getDescription() {
        return "当你要被杀死时，免死并回复到最大生命值的 30% ，丢弃这瓶药水。";
    }
}
