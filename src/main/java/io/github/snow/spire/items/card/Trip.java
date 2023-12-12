package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Trip extends ColorlessCard {
    private static final String DESC = "给予2层 【易伤】  。";
    private static final String DESC1 = "给予所有敌人2层 【易伤】 。";

    public Trip(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "绊倒";
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
