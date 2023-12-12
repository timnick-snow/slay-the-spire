package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Wish extends PurpleCard {
    private static final String DESC = "选择：获得6层多层护甲，3点 【力量】 或25金币。 【消耗】 。";
    private static final String DESC1 = "选择：获得8层多层护甲，4点 【力量】 或30金币。 【消耗】 。";

    public Wish(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "许愿";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return 3;
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
