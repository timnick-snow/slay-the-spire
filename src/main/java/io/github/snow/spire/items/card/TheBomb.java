package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class TheBomb extends ColorlessCard {
    private static final String DESC = "在3回合结束后，对所有敌人造成40点伤害。";
    private static final String DESC1 = "在3回合结束后，对所有敌人造成50点伤害。";

    public TheBomb(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "炸弹";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
