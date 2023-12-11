package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class SwiftPotion extends CommonPotion {
    public SwiftPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "迅捷药水";
    }

    @Override
    public String getDescription() {
        return "抽 3 张牌。";
    }
}
