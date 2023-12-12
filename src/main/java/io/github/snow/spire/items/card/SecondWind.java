package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SecondWind extends RedCard {
    private static final String DESC = " 【消耗】 手牌中所有非攻击牌，每张获得5点 【格挡】 。";
    private static final String DESC1 = " 【消耗】 手牌中所有非攻击牌，每张获得7点 【格挡】 。";

    public SecondWind(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "重振精神";
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
