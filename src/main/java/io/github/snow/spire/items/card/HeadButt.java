package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HeadButt extends RedCard {
    private static final String DESC = "造成9点伤害。将弃牌堆中的一张牌放到抽牌堆的顶部。";
    private static final String DESC1 = "造成12点伤害。将弃牌堆中的一张牌放到抽牌堆的顶部。";

    public HeadButt(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "头槌";
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
