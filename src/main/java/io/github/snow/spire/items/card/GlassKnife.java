package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class GlassKnife extends GreenCard {
    private static final String DESC = "造成8点伤害两次。这张牌每被打出一次，在本场战斗中其基础伤害减少2。";
    private static final String DESC1 = "造成12点伤害两次。这张牌每被打出一次，在本场战斗中其基础伤害减少2。";

    public GlassKnife(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "玻璃刀刃";
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
