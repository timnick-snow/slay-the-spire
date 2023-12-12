package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Doppelganger extends GreenCard {
    private static final String DESC = "下一回合，抽X张牌，获得X[G]。 【消耗】 。";
    private static final String DESC1 = "下一回合，抽X+1张牌，获得X+1 [G] 。 【消耗】 。";

    public Doppelganger(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双重存在";
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
        return -1;
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
