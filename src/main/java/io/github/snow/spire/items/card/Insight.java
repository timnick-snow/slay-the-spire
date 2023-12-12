package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Insight extends ColorlessCard {
    private static final String DESC = " 【保留】 。抽2张牌。 【消耗】 。";
    private static final String DESC1 = " 【保留】 。抽3张牌。 【消耗】 。";

    public Insight(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "洞见";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }

    @Override
    public int cost() {
        return 0;
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
