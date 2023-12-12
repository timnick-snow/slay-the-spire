package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Offering extends RedCard {
    private static final String DESC = "失去6点生命。获得[R][R]。抽3张牌。 【消耗】 。";
    private static final String DESC1 = "失去6点生命。获得[R][R]。抽5张牌。 【消耗】 。";

    public Offering(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "祭品";
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
