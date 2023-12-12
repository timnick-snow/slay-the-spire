package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Dash extends GreenCard {
    private static final String DESC = "获得10点 【格挡】 。造成 10点伤害。";
    private static final String DESC1 = "获得13点 【格挡】 。造成13点伤害。";

    public Dash(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "冲刺";
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
