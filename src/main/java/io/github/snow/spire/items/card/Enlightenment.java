package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Enlightenment extends ColorlessCard {
    private static final String DESC = "在这个回合，你当前手牌中所有牌的耗能降低到1。";
    private static final String DESC1 = "在本场战斗，你当前手牌中所有牌的耗能降低到1.";

    public Enlightenment(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "开悟";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
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
