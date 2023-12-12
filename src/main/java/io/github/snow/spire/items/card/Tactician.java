package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Tactician extends GreenCard {
    private static final String DESC = " 【不能被打出】 。如果这张牌从你的手牌中被丢弃，获得[G]。";
    private static final String DESC1 = " 【不能被打出】 。如果这张牌从你的手牌中被丢弃，获得[G][G]。";

    public Tactician(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "战术大师";
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
        return -2;
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
