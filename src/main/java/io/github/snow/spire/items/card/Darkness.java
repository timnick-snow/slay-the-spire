package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Darkness extends BlueCard {
    private static final String DESC = " 【生成】 1个 【黑暗】 充能球。";
    private static final String DESC1 = " 【生成】 1个 【黑暗】 充能球。使用所有 【黑暗】 充能球的被动能力。";

    public Darkness(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "漆黑";
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
