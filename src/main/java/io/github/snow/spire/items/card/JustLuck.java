package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class JustLuck extends PurpleCard {
    private static final String DESC = " 【预见】 1。获得2点 【格挡】 。造成3点伤害。";
    private static final String DESC1 = " 【预见】 2。获得3点 【格挡】 。造成4点伤害。";

    public JustLuck(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "幸运一击";
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
