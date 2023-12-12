package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Worship extends PurpleCard {
    private static final String DESC = "获得5层 【真言】 。";
    private static final String DESC1 = " 【保留】 。获得5层 【真言】 。";

    public Worship(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "敬拜";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
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
