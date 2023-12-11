package io.github.snow.spire.items.potion;

/**
 * @author snow
 * @since 2023-12-11
 */
public class FearPotion extends CommonPotion {
    public FearPotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "恐惧药水";
    }

    @Override
    public String getDescription() {
        return "给予 3 层 易伤 。";
    }
}
