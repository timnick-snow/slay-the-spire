package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class FruitJuice extends RarePotion {
    public FruitJuice(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "果汁";
    }

    @Override
    public String getDescription() {
        return "获得 5 点最大生命。";
    }
}
