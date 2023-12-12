package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Evolve extends RedCard {
    private static final String DESC = "每当你抽到一张 【状态牌】 时，抽1张牌。";
    private static final String DESC1 = "每当你抽到一张 【状态牌】 时，抽2张牌。";

    public Evolve(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "进化";
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
