package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;

/**
 * @author snow
 * @since 2023/12/12
 */
public class AscendersBane extends CurseCard {
    public AscendersBane(String id) {
        super(id);
    }

    @Override
    public String baseName() {
        return "进阶之灾";
    }

    @Override
    public String description() {
        return " 【不能被打出】 。 【虚无】 。 无法从牌组中移除 。";
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }

    @Override
    public boolean isRemovable() {
        return false;
    }
}
