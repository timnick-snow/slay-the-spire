package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Cleave extends RedCard {
    private static final String DESC = "对所有敌人造成8点伤害。";
    private static final String DESC1 = "对所有敌人造成11点伤害。";

    public Cleave(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "顺劈斩";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
