package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Malaise extends GreenCard {
    private static final String DESC = "敌人失去X点 【力量】 ，给予X层 【虚弱】 。 【消耗】 。";
    private static final String DESC1 = "敌人失去X+1点 【力量】 ，给予X+1层 【虚弱】 。 【消耗】 。";

    public Malaise(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "萎靡";
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
        return -1;
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
