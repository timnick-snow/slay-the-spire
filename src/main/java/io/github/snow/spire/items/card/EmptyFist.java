package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class EmptyFist extends PurpleCard {
    private static final String DESC = "造成9点伤害。退出当前 【姿态】 。";
    private static final String DESC1 = "造成14点伤害。退出当前 【姿态】 。";

    public EmptyFist(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "化拳为空";
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
