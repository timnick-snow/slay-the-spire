package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ReinforcedBody extends BlueCard {
    private static final String DESC = "获得7点 【格挡】 X次。";
    private static final String DESC1 = "获得9点 【格挡】 X次。";

    public ReinforcedBody(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "硬化机体";
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
        return -1;
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
