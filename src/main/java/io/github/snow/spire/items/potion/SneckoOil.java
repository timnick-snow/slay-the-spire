package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class SneckoOil extends RarePotion {
    public SneckoOil(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "异蛇之油";
    }

    @Override
    public String getDescription() {
        return "抽 5 张牌。随机化你手牌的耗能。";
    }
}
