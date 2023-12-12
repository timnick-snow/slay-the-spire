package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SpotWeakness extends RedCard {
    private static final String DESC = "如果一名敌人的意图是攻击，你获得3点 【力量】 。";
    private static final String DESC1 = "如果一名敌人的意图是攻击，你获得4点 【力量】 。";

    public SpotWeakness(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "观察弱点";
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
