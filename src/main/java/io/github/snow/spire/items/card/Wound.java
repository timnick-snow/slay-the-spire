package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Wound extends ColorlessCard {
    private static final String DESC = " 【不能被打出】 。";
    private static final String DESC1 = "null";

    public Wound(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "伤口";
    }

    @Override
    public CardType type() {
        return CardType.STATUS;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }

    @Override
    public int cost() {
        return -2;
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
