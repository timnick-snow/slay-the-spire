package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class MachineLearning extends BlueCard {
    private static final String DESC = "在每回合开始时额外抽1张牌。";
    private static final String DESC1 = " 【固有】 。在每回合开始时额外抽1张牌。";

    public MachineLearning(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "机器学习";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
