package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Nirvana extends PurpleCard {
    private static final String DESC = "你每次 【预见】 时，获得3点 【格挡】 。";
    private static final String DESC1 = "你每次 【预见】 时，获得4点 【格挡】 。";

    public Nirvana(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "涅槃";
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
