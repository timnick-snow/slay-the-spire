package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Recycle extends BlueCard {
    private static final String DESC = " 【消耗】 一张牌。获得与其耗能相等的[B]。";
    private static final String DESC1 = " 【消耗】 一张牌。获得与其耗能相等的[B]。";

    public Recycle(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "回收";
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
        return level == 0 ? 1 : 0;
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
