package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WildStrike extends RedCard {
    private static final String DESC = "造成12点伤害。将一张 【伤口】 放入你的抽牌堆中。";
    private static final String DESC1 = "造成17点伤害。将一张 【伤口】 放入你的抽牌堆中。";

    public WildStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "狂野打击";
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
