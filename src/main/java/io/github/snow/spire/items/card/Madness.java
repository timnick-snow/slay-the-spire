package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Madness extends ColorlessCard {
    private static final String DESC = "你手牌中一张随机牌在本场战斗中耗能变为0。 【消耗】 。";
    private static final String DESC1 = "你手牌中一张随机牌在本场战斗中耗能变为0。 【消耗】 。";

    public Madness(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "疯狂";
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
