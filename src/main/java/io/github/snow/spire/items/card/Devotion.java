package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Devotion extends PurpleCard {
    private static final String DESC = "在你的回合开始时，获得2层 【真言】 。";
    private static final String DESC1 = "在你的回合开始时，获得3层 【真言】 。";

    public Devotion(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "虔信";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
