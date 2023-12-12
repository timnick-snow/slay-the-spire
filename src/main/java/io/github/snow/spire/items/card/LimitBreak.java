package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class LimitBreak extends RedCard {
    private static final String DESC = "将你的 【力量】 翻倍。 【消耗】 。";
    private static final String DESC1 = "将你的 【力量】 翻倍。";

    public LimitBreak(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "突破极限";
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
