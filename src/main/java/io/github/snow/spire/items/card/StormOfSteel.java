package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class StormOfSteel extends GreenCard {
    private static final String DESC = "丢弃所有手牌。每丢弃一张牌，在你的手牌中增加一张 【小刀】 。";
    private static final String DESC1 = "丢弃所有手牌。每丢弃一张牌，在你的手牌中增加一张 【小刀|小刀+】 。";

    public StormOfSteel(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "钢铁风暴";
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
