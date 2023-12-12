package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Rampage extends RedCard {
    private static final String DESC = "造成8点伤害。这张牌每被打出一次，在本场战斗中其伤害增加5。";
    private static final String DESC1 = "造成8点伤害。这张牌每被打出一次，在本场战斗中其伤害增加8。";

    public Rampage(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "暴走";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
