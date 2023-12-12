package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class RecklessCharge extends RedCard {
    private static final String DESC = "造成7点伤害。将一张 【晕眩】 放入你的抽牌堆中。";
    private static final String DESC1 = "造成10点伤害。将一张 【晕眩】 放入你的抽牌堆中。";

    public RecklessCharge(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "无谋冲锋";
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
