package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class InfiniteBlades extends GreenCard {
    private static final String DESC = "在你的回合开始时，增加一张 【小刀】 到你的手牌。";
    private static final String DESC1 = " 【固有】 。在你的回合开始时，增加一张 【小刀】 到你的手牌。";

    public InfiniteBlades(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "无限刀刃";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
