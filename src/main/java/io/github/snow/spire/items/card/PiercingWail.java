package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PiercingWail extends GreenCard {
    private static final String DESC = "所有敌人失去6力量1回合。 【消耗】 。";
    private static final String DESC1 = "所有敌人失去8力量1回合。 【消耗】 。";

    public PiercingWail(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "尖啸";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
