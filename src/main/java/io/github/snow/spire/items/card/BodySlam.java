package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BodySlam extends RedCard {
    private static final String DESC = "造成你当前 【格挡】 值的伤害。";
    private static final String DESC1 = "造成你当前 【格挡】 值的伤害。";

    public BodySlam(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "全身撞击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 1 : 0;
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
