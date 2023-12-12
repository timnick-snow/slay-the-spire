package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CripplingPoison extends GreenCard {
    private static final String DESC = "给予所有敌人4层 【中毒】 和2层 【虚弱】 。 【消耗】 。";
    private static final String DESC1 = "给予所有敌人7层 【中毒】 和2层 【虚弱】 。 【消耗】 。";

    public CripplingPoison(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "致残毒云";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
