package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BloodyIdol extends EventRelic {
    @Override
    public String name() {
        return "鲜血神像";
    }

    @Override
    public String description() {
        return "每当你获得 【金币】 时，回复 5 点生命。";
    }
}
