package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DramaticEntrance extends ColorlessCard {
    private static final String DESC = " 【固有】 。对所有敌人造成8点伤害。 【消耗】 。";
    private static final String DESC1 = " 【固有】 。对所有敌人造成12点伤害。 【消耗】 。";

    public DramaticEntrance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "闪亮登场";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return 0;
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
