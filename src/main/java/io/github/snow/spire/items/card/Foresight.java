package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Foresight extends PurpleCard {
    private static final String DESC = "在你的回合开始时， 【预见】 3。";
    private static final String DESC1 = "在你的回合开始时， 【预见】 4。";

    public Foresight(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "先见之明";
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
