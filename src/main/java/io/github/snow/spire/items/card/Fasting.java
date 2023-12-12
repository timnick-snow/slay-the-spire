package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Fasting extends PurpleCard {
    private static final String DESC = "获得3点 【力量】 。获得3 【敏捷】 。每回合开始时少获得1[P]。";
    private static final String DESC1 = "获得4点 【力量】 。获得4 【敏捷】 。每回合开始时少获得1[P]。";

    public Fasting(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "斋戒";
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
