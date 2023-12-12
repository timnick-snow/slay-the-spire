package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Pummel extends RedCard {
    private static final String DESC = "造成2点伤害4次。 【消耗】 。";
    private static final String DESC1 = "造成2点伤害5次。 【消耗】 。";

    public Pummel(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "连续拳";
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
