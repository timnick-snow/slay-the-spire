package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Uppercut extends RedCard {
    private static final String DESC = "造成13点伤害。给予1层 【虚弱】 。给予1层 【易伤】 。";
    private static final String DESC1 = "造成13点伤害。给予2层 【虚弱】 。给予2层 【易伤】 。";

    public Uppercut(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "上勾拳";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return 2;
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
