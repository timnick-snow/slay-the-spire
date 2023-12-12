package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;

/**
 * @author snow
 * @since 2023/12/12
 */
public class NecronomiCurse extends CurseCard {
    public NecronomiCurse(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "死灵诅咒";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。这个诅咒无法逃脱。";
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }
}
