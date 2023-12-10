package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Pear extends UncommonRelic {
    @Override
    public String name() {
        return "梨子";
    }

    @Override
    public String description() {
        return "拾起时，将你的最大生命值提升 10 。";
    }
}
