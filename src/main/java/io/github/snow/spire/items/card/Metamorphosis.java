package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Metamorphosis extends ColorlessCard {
    private static final String DESC = "在你的抽牌堆中加入3张随机攻击牌。它们在本场战斗中耗能为0。 【消耗】 。";
    private static final String DESC1 = "在你的抽牌堆中加入5张随机攻击牌。它们在本场战斗中耗能为0。 【消耗】 。";

    public Metamorphosis(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "羽化";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
