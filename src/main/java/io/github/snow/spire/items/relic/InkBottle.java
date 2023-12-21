package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class InkBottle extends UncommonRelic {
    @Override
    public String displayName() {
        return "墨水瓶";
    }

    @Override
    public String description() {
        return "你每打出 10 张牌，抽 1 张牌。";
    }
}
