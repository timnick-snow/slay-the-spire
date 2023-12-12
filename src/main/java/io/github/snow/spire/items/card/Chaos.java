package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Chaos extends BlueCard {
    private static final String DESC = " 【生成】 1个随机充能球。";
    private static final String DESC1 = " 【生成】 2个随机充能球。";

    public Chaos(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "混沌";
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
