package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Choke extends GreenCard {
    private static final String DESC = "造成12点伤害。你在这个回合内每打出一张牌，该名敌人都会失去3点生命。";
    private static final String DESC1 = "造成12点伤害。你在这个回合内每打出一张牌，该名敌人都会失去5点生命。";

    public Choke(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "勒脖";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
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
