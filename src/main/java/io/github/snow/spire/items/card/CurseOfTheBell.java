package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CurseOfTheBell extends CurseCard {
    public CurseOfTheBell(String id) {
        super(id);
    }

    @Override
    public String name() {
        return "铃铛的诅咒";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。 无法从牌组中移除 。";
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }
}
