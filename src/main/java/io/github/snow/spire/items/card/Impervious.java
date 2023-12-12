package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Impervious extends RedCard {
    private static final String DESC = "获得30点 【格挡】 。 【消耗】 。";
    private static final String DESC1 = "获得40点 【格挡】 。 【消耗】 。";

    public Impervious(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "岿然不动";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return 2;
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
