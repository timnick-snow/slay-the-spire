package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SadisticNature extends ColorlessCard {
    private static final String DESC = "每当你对一名敌人造成负面状态，使对方受到5点伤害。";
    private static final String DESC1 = "每当你对一名敌人造成负面状态，使对方受到7点伤害。";

    public SadisticNature(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "残虐天性";
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
        return 0;
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
