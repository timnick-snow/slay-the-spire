package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RedSkull extends CommonRelic {
    @Override
    public String name() {
        return "红头骨";
    }

    @Override
    public String description() {
        return "当你的生命值等于或低于 50% 时， 你获得额外 3点 【力量】。";
    }
}
