package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Disarm extends RedCard {
    private static final String DESC = "使敌人失去2点 【力量】 。 【消耗】 。";
    private static final String DESC1 = "使敌人失去3点 【力量】 。 【消耗】 。";

    public Disarm(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "缴械";
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
