package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CrushJoints extends PurpleCard {
    private static final String DESC = "造成8点伤害。如果本场战斗打出的上一张牌是技能牌，给予1层 【易伤】 。";
    private static final String DESC1 = "造成10点伤害。如果本场战斗打出的上一张牌是技能牌，给予2层 【易伤】 。";

    public CrushJoints(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "粉碎关节";
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
