package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class JAX extends ColorlessCard {
    private static final String DESC = "失去3点生命。获得2点 【力量】 。";
    private static final String DESC1 = "失去3点生命。获得3点 【力量】 。";

    public JAX(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "J.A.X.";
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
