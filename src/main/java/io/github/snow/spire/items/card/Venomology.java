package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Venomology extends GreenCard {
    private static final String DESC = "获得一瓶随机药水。 【消耗】 。";
    private static final String DESC1 = "获得一瓶随机药水。 【消耗】 。";

    public Venomology(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "炼制药水";
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
