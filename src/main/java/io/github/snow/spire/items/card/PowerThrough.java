package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PowerThrough extends RedCard {
    private static final String DESC = "增加2张 【伤口】 到你的手牌。获得15点 【格挡】 。";
    private static final String DESC1 = "增加2张 【伤口】 到你的手牌。获得20点 【格挡】 。";

    public PowerThrough(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "硬撑";
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
