package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class GeneticAlgorithm extends BlueCard {
    private static final String DESC = "获得1点 【格挡】 。每打出一次，这张牌在本局游戏中的格挡值永久性增加2。 【消耗】 。";
    private static final String DESC1 = "获得1点 【格挡】 。每打出一次，这张牌在本局游戏中的格挡值永久性增加3。 【消耗】 。";

    public GeneticAlgorithm(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "遗传算法";
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
