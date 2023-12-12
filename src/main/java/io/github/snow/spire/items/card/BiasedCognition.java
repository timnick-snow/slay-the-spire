package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BiasedCognition extends BlueCard {
    private static final String DESC = "获得4点 【集中】 。在每回合开始时，失去1点 【集中】 。";
    private static final String DESC1 = "获得5点 【集中】 。在每回合开始时，失去1点 【集中】 。";

    public BiasedCognition(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "偏差认知";
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
