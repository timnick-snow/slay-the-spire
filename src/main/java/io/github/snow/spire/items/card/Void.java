package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Void extends ColorlessCard {
    private static final String DESC = " 【不能被打出】 。抽到这张牌时失去1点能量。 【虚无】 。";
    private static final String DESC1 = "null";

    public Void(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "虚空";
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
