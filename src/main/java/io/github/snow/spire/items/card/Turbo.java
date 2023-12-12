package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Turbo extends BlueCard {
    private static final String DESC = "获得[B][B]。将一张 【虚空】 放入你的弃牌堆中。";
    private static final String DESC1 = "获得[B][B][B]。将一张 【虚空】 放入你的弃牌堆中。";

    public Turbo(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "内核加速";
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
