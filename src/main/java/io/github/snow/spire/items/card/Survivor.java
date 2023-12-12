package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Survivor extends GreenCard {
    private static final String DESC = "获得8点 【格挡】 。丢弃一张牌。";
    private static final String DESC1 = "获得11点 【格挡】 。丢弃一张牌。";

    public Survivor(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "生存者";
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
