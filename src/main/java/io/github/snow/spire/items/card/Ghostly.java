package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Ghostly extends ColorlessCard {
    private static final String DESC = "获得1层无实体。 【消耗】 。 【虚无】 。";
    private static final String DESC1 = "获得1层无实体。 【消耗】 。";

    public Ghostly(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "灵体";
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
