package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Shockwave extends RedCard {
    private static final String DESC = "给予所有敌人3层 【虚弱】 和 【易伤】 。 【消耗】 。";
    private static final String DESC1 = "给予所有敌人5层 【虚弱】 和 【易伤】 。 【消耗】 。";

    public Shockwave(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "震荡波";
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
