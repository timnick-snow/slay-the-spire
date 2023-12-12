package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Footwork extends GreenCard {
    private static final String DESC = "获得2点 【敏捷】 。";
    private static final String DESC1 = "获得3点 【敏捷】 。";

    public Footwork(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "灵动步法";
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
