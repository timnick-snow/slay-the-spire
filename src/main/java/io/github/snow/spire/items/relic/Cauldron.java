package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Cauldron extends ShopRelic {
    @Override
    public String name() {
        return "大锅";
    }

    @Override
    public String description() {
        return "拾起时，制作 5 瓶随机药水。";
    }
}
