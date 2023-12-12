package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Bite extends ColorlessCard {
    private static final String DESC = "造成7点伤害。回复2点生命。";
    private static final String DESC1 = "造成8点伤害。回复3点生命。";

    public Bite(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "噬咬";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
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
