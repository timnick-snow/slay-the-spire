package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DeadlyPoison extends GreenCard {
    private static final String DESC = "给予5层 【中毒】 。";
    private static final String DESC1 = "给予7层 【中毒】 。";

    public DeadlyPoison(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "致命毒药";
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
