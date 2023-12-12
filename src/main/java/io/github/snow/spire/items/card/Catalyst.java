package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Catalyst extends GreenCard {
    private static final String DESC = "将一名敌人的 【中毒】 层数翻倍。 【消耗】 。";
    private static final String DESC1 = "将一名敌人的 【中毒】 层数变为三倍。 【消耗】 。";

    public Catalyst(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "催化剂";
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
