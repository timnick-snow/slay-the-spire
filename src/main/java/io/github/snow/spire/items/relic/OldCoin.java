package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class OldCoin extends RareRelic {
    @Override
    public String displayName() {
        return "古钱币";
    }

    @Override
    public String description() {
        return "拾起时，获得 300 【金币】 。";
    }
}
