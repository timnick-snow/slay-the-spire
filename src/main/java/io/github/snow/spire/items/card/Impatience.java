package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Impatience extends ColorlessCard {
    private static final String DESC = "如果你的手牌中没有攻击牌，抽2张牌。";
    private static final String DESC1 = "如果你的手牌中没有攻击牌，抽3张牌。";

    public Impatience(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "急躁";
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
