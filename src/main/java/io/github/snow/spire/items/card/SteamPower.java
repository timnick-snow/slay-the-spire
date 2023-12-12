package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SteamPower extends BlueCard {
    private static final String DESC = "抽2张牌。将一张 【灼伤】 放入你的弃牌堆中。";
    private static final String DESC1 = "抽3张牌。将一张 【灼伤】 放入你的弃牌堆中。";

    public SteamPower(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "超频";
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
