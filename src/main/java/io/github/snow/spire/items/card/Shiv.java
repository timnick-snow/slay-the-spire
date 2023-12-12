package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Shiv extends ColorlessCard {
    private static final String DESC = "造成4点伤害。 【消耗】 。";
    private static final String DESC1 = "造成6点伤害。 【消耗】 ";

    public Shiv(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "小刀";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
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
