package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Tempest extends BlueCard {
    private static final String DESC = " 【生成】 X个 【闪电】 充能球。 【消耗】 。";
    private static final String DESC1 = " 【生成】 X+1个 【闪电】 充能球。 【消耗】 。";

    public Tempest(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "暴风雨";
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
