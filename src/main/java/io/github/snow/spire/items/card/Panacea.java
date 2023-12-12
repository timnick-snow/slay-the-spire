package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Panacea extends ColorlessCard {
    private static final String DESC = "获得1层 【人工制品】 。 【消耗】 。";
    private static final String DESC1 = "获得2层 【人工制品】 。 【消耗】 。";

    public Panacea(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "万能药";
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
