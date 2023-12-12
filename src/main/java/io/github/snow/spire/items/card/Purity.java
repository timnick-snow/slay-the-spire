package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Purity extends ColorlessCard {
    private static final String DESC = "从手牌中选择最多3张牌 【消耗】 。 【消耗】 。";
    private static final String DESC1 = "从手牌中选择最多5张牌 【消耗】 。 【消耗】 。";

    public Purity(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "净化";
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
