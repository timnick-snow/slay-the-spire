package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ThirdEye extends PurpleCard {
    private static final String DESC = "获得7点 【格挡】 。 【预见】 3 。";
    private static final String DESC1 = "获得9点 【格挡】 。 【预见】 5 。";

    public ThirdEye(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "天眼";
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
