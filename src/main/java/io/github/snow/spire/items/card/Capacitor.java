package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Capacitor extends BlueCard {
    private static final String DESC = "获得2个充能球栏位。";
    private static final String DESC1 = "获得3个充能球栏位。";

    public Capacitor(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "扩容";
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
