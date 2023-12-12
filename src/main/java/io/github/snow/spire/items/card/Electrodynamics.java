package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Electrodynamics extends BlueCard {
    private static final String DESC = " 【闪电】 充能球现在会击中所有敌人。 【生成】 2个 【闪电】 充能球。";
    private static final String DESC1 = " 【闪电】 充能球现在会击中所有敌人。 【生成】 3个 【闪电】 充能球。";

    public Electrodynamics(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "电动力学";
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
        return 2;
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
