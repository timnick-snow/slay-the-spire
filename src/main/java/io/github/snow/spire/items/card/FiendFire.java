package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FiendFire extends RedCard {
    private static final String DESC = " 【消耗】 所有手牌。每张被消耗的牌造成7点伤害。 【消耗】 。";
    private static final String DESC1 = " 【消耗】 所有手牌。每张被消耗的牌造成10点伤害。 【消耗】 。";

    public FiendFire(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "恶魔之焰";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
