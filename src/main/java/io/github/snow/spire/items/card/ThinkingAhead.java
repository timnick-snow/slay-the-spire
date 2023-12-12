package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ThinkingAhead extends ColorlessCard {
    private static final String DESC = "抽2张牌，然后将手牌中的一张牌放到你抽牌堆的顶端。 【消耗】 。";
    private static final String DESC1 = "抽2张牌，然后将手牌中的一张牌放到你抽牌堆的顶端。";

    public ThinkingAhead(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "深谋远虑";
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
