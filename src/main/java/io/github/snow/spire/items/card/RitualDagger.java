package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class RitualDagger extends ColorlessCard {
    private static final String DESC = "造成15点伤害。 【斩杀】 时，它在本局游戏中的伤害永久性增加3。 【消耗】 。";
    private static final String DESC1 = "造成15点伤害。 【斩杀】 时，它在本局游戏中的伤害永久性增加5。 【消耗】 。";

    public RitualDagger(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "仪式匕首";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
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
