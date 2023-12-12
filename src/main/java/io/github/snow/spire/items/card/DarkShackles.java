package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DarkShackles extends ColorlessCard {
    private static final String DESC = "让一名敌人在本回合内失去9点 【力量】 。 【消耗】 。";
    private static final String DESC1 = "让一名敌人在本回合内失去15点 【力量】 。 【消耗】 。";

    public DarkShackles(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "黑暗镣铐";
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
