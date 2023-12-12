package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Apotheosis extends ColorlessCard {
    private static final String DESC = "在本场战斗中 【升级】 你的所有牌。 【消耗】 。";
    private static final String DESC1 = "在本场战斗中 【升级】 你的所有牌。 【消耗】 。";

    public Apotheosis(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "神化";
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
        return level == 0 ? 2 : 1;
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
