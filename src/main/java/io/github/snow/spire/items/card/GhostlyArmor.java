package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class GhostlyArmor extends RedCard {
    private static final String DESC = " 【虚无】 。获得10点 【格挡】 。";
    private static final String DESC1 = " 【虚无】 。获得13点 【格挡】 。";

    public GhostlyArmor(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "幽灵铠甲";
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
