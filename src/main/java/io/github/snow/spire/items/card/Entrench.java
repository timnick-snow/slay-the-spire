package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Entrench extends RedCard {
    private static final String DESC = "将你当前的 【格挡】 翻倍。";
    private static final String DESC1 = "将你当前的 【格挡】 翻倍。";

    public Entrench(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "巩固";
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
        return level == 0 ? 2 : 1;
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
