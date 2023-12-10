package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MawBank extends CommonRelic {
    @Override
    public String name() {
        return "巨口储蓄罐";
    }

    @Override
    public String description() {
        return "每攀爬一层楼层获得 12 【金币】 。一旦在商店中花费 【金币】 就会失效。";
    }
}
