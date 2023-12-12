package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Vigilance extends PurpleCard {
    private static final String DESC = "获得8点 【格挡】 。进入 【平静】 。";
    private static final String DESC1 = "获得12点 【格挡】 。进入 【平静】 。";

    public Vigilance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "警惕";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
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
