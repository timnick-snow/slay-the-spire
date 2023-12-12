package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BootSequence extends BlueCard {
    private static final String DESC = "获得10点 【格挡】 。 【固有】 。 【消耗】 。";
    private static final String DESC1 = "获得13点 【格挡】 。 【固有】 。 【消耗】 。";

    public BootSequence(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "启动流程";
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
