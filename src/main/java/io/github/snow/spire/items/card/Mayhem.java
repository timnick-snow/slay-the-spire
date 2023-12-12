package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Mayhem extends ColorlessCard {
    private static final String DESC = "在你的回合开始时，打出你抽牌堆顶部的牌。";
    private static final String DESC1 = "在你的回合开始时，打出你抽牌堆顶部的牌。";

    public Mayhem(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "乱战";
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
