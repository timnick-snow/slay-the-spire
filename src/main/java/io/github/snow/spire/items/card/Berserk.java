package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Berserk extends RedCard {
    private static final String DESC = "获得2层 【易伤】 。每回合开始时获得[R]。";
    private static final String DESC1 = "获得1层 【易伤】 。每回合开始时获得[R]。";

    public Berserk(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "狂暴";
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
