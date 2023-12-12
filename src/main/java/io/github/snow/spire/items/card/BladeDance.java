package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BladeDance extends GreenCard {
    private static final String DESC = "增加3张 【小刀】 到你的手牌。";
    private static final String DESC1 = "增加4张 【小刀】 到你的手牌。";

    public BladeDance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "刀刃之舞";
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
