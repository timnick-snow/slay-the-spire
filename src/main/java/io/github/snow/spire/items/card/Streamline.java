package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Streamline extends BlueCard {
    private static final String DESC = "造成15点伤害。这张牌每被打出一次，它在本场战斗中的耗能减少1。";
    private static final String DESC1 = "造成20点伤害。这张牌每被打出一次，它在本场战斗中的耗能减少1。";

    public Streamline(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "精简改良";
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
