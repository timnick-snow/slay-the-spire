package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Reprogram extends BlueCard {
    private static final String DESC = "失去1点 【集中】 。获得1点 【力量】 。获得1点 【敏捷】 。";
    private static final String DESC1 = "失去2点 【集中】 。获得2点 【力量】 。获得2点 【敏捷】 。";

    public Reprogram(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "重编程";
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
