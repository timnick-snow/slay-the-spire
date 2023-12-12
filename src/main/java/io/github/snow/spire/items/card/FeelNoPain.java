package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FeelNoPain extends RedCard {
    private static final String DESC = "每当有一张牌被 【消耗】 ，获得3点 【格挡】 。";
    private static final String DESC1 = "每当有一张牌被 【消耗】 ，获得4点 【格挡】 。";

    public FeelNoPain(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "无惧疼痛";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
