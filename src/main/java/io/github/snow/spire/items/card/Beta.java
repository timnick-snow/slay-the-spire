package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Beta extends ColorlessCard {
    private static final String DESC = "将一张 【欧米伽】 放入你的抽牌堆中。 【消耗】 。";
    private static final String DESC1 = "将一张 【欧米伽】 放入你的抽牌堆中。 【消耗】 。";

    public Beta(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "贝塔";
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
        return level == 0 ? 2 : 1;
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
