package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class IceCream extends RareRelic {
    @Override
    public String displayName() {
        return "冰淇淋";
    }

    @Override
    public String description() {
        return "多余的【能量】可以留到下一回合。";
    }
}
