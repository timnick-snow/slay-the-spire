package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Clash extends RedCard {
    private static final String DESC = "只有在手牌每一张牌都是攻击牌时才能被打出。造成14点伤害。";
    private static final String DESC1 = "只有在手牌每一张牌都是攻击牌时才能被打出。造成18点伤害。";

    public Clash(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "交锋";
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
        return 0;
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
