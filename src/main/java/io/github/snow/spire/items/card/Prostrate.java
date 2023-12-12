package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Prostrate extends PurpleCard {
    private static final String DESC = "获得2层 【真言】 。获得4点 【格挡】 。";
    private static final String DESC1 = "获得3层 【真言】 。获得4点 【格挡】 。";

    public Prostrate(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "五体投地";
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
