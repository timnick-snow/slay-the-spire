package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HeavyBlade extends RedCard {
    private static final String DESC = "造成14点伤害。 【力量】 在重刃上发挥3倍效果。";
    private static final String DESC1 = "造成14点伤害。 【力量】 在重刃上发挥5倍效果。";

    public HeavyBlade(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "重刃";
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
        return 2;
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
