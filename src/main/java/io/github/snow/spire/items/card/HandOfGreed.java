package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HandOfGreed extends ColorlessCard {
    private static final String DESC = "造成20点伤害。 【斩杀】 时，获得20金币。";
    private static final String DESC1 = "造成25点伤害。 【斩杀】 时，获得25金币。";

    public HandOfGreed(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "贪婪之手";
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
