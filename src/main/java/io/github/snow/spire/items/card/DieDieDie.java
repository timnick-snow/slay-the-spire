package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DieDieDie extends GreenCard {
    private static final String DESC = "对所有敌人造成13点伤害。 【消耗】 。";
    private static final String DESC1 = "对所有敌人造成17点伤害。 【消耗】 。";

    public DieDieDie(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "死吧死吧死吧";
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
