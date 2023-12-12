package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class EmptyBody extends PurpleCard {
    private static final String DESC = "获得7点 【格挡】 。退出当前 【姿态】 。";
    private static final String DESC1 = "获得10点 【格挡】 。退出当前 【姿态】 。";

    public EmptyBody(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "化体为空";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
