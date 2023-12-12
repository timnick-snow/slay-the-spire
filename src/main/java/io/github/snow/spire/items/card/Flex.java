package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Flex extends RedCard {
    private static final String DESC = "获得2点 【力量】 。你的回合结束时，失去2点 【力量】 。";
    private static final String DESC1 = "获得4点 【力量】 。你的回合结束时，失去4点 【力量】 。";

    public Flex(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "活动肌肉";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
