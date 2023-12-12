package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class JackOfAllTrades extends ColorlessCard {
    private static final String DESC = "增加1张随机无色牌到你的手牌。 【消耗】 。";
    private static final String DESC1 = "增加2张随机无色牌到你的手牌。 【消耗】 。";

    public JackOfAllTrades(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "花样百出";
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
