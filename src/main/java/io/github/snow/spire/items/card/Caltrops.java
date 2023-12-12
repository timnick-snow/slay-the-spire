package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Caltrops extends GreenCard {
    private static final String DESC = "每当你被攻击时，对攻击者造成3点伤害。";
    private static final String DESC1 = "每当你被攻击时，对攻击者造成5点伤害。";

    public Caltrops(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "铁蒺藜";
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
