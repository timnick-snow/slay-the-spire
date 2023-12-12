package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Blasphemy extends PurpleCard {
    private static final String DESC = "进入 【神格】 。在下回合死亡。 【消耗】 。";
    private static final String DESC1 = " 【保留】 。进入 【神格】 。在下回合死亡。 【消耗】 。";

    public Blasphemy(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "渎神";
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
