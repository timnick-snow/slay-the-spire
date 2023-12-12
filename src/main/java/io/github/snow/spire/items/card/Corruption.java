package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Corruption extends RedCard {
    private static final String DESC = "所有技能牌耗能变为0。所有技能牌在被打出时被 【消耗】 。";
    private static final String DESC1 = "所有技能牌耗能变为0。所有技能牌在被打出时被 【消耗】 。";

    public Corruption(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "腐化";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return level == 0 ? 3 : 2;
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
