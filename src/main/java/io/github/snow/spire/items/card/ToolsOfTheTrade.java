package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ToolsOfTheTrade extends GreenCard {
    private static final String DESC = "在你的回合开始时，抽1张牌，丢弃1张牌。";
    private static final String DESC1 = "在你的回合开始时，抽1张牌，丢弃1张牌。";

    public ToolsOfTheTrade(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "必备工具";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return level == 0 ? 1 : 0;
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
