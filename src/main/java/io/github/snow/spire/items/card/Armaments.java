package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Armaments extends RedCard {
    private static final String DESC = "获得5点 【格挡】 。在本场战斗中 【升级】 手牌中的一张牌。";
    private static final String DESC1 = "获得5点 【格挡】 。在本场战斗中 【升级】 手牌中的所有牌。";

    public Armaments(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "武装";
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
