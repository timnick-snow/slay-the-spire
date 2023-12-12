package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Heatsinks extends BlueCard {
    private static final String DESC = "你每打出一张能力牌，抽1张牌。";
    private static final String DESC1 = "你每打出一张能力牌，抽2张牌。";

    public Heatsinks(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "散热片";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
