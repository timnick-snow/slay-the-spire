package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SuckerPunch extends GreenCard {
    private static final String DESC = "造成7点伤害。给予1层 【虚弱】 。";
    private static final String DESC1 = "造成9点伤害。 给予2层 【虚弱】 。";

    public SuckerPunch(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "突然一拳";
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
