package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Panache extends ColorlessCard {
    private static final String DESC = "你每在同个回合内打出5张牌，就对所有敌人造成10点伤害。";
    private static final String DESC1 = "你每在同个回合内打出5张牌，就对所有敌人造成14点伤害。";

    public Panache(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "神气制胜";
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
