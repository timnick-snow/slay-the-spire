package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Perseverance extends PurpleCard {
    private static final String DESC = " 【保留】 。获得7点 【格挡】 。每当这张牌被 【保留】 时，将其在本场战斗的格挡增加2点。";
    private static final String DESC1 = " 【保留】 。获得7点 【格挡】 。每当这张牌被 【保留】 时，将其在本场战斗的格挡增加3点。";

    public Perseverance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "坚韧";
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
