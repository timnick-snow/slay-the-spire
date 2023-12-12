package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WellLaidPlans extends GreenCard {
    private static final String DESC = "在你的回合结束时， 【保留】 最多1张牌。";
    private static final String DESC1 = "在你的回合结束时， 【保留】 最多2张牌。";

    public WellLaidPlans(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "计划妥当";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
