package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Protect extends PurpleCard {
    private static final String DESC = " 【保留】 。获得12点 【格挡】 。";
    private static final String DESC1 = " 【保留】 。获得16点 【格挡】 。";

    public Protect(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "护身";
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
