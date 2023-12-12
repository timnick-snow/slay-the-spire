package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Inflame extends RedCard {
    private static final String DESC = "获得2点 【力量】 。";
    private static final String DESC1 = "获得3点 【力量】 。";

    public Inflame(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "燃烧";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String description() {
        return level == 0 ? DESC : DESC1;
    }

    @Override
    public String upgradeDescription() {
        return DESC1;
    }
}
