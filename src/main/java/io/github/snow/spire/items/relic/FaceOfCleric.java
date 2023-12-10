package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class FaceOfCleric extends EventRelic {
    @Override
    public String name() {
        return "牧师的脸";
    }

    @Override
    public String description() {
        return "每场战斗后你的最大生命值增加 1 。";
    }
}
