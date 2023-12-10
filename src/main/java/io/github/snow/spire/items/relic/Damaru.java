package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Damaru extends CommonRelic {
    @Override
    public String name() {
        return "手摇鼓";
    }

    @Override
    public String description() {
        return "在你的回合开始时，获得 1 层 【真言】 。";
    }
}
