package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DoubleEnergy extends BlueCard {
    private static final String DESC = "将你的能量翻倍。 【消耗】 。";
    private static final String DESC1 = "将你的能量翻倍。 【消耗】 。";

    public DoubleEnergy(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双倍能量";
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
