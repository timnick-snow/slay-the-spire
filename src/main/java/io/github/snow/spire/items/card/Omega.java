package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Omega extends ColorlessCard {
    private static final String DESC = "在你的回合结束时，对所有敌人造成50点伤害。";
    private static final String DESC1 = "在你的回合结束时，对所有敌人造成60点伤害。";

    public Omega(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "欧米伽";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.SPECIAL;
    }

    @Override
    public int cost() {
        return 3;
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
