package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CalculatedGamble extends GreenCard {
    private static final String DESC = "丢弃所有手牌。然后抽相同数量张牌。 【消耗】 。";
    private static final String DESC1 = "丢弃所有手牌。 然后抽相同数量张牌。";

    public CalculatedGamble(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "计算下注";
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
