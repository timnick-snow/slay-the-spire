package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PressurePoints extends PurpleCard {
    private static final String DESC = "给予8层[[印记]]。所有拥有[[印记]]的敌人失去与层数相等的生命。";
    private static final String DESC1 = "给予11层[[印记]]。所有拥有[[印记]]的敌人失去与层数相等的生命。";

    public PressurePoints(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "点穴";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
