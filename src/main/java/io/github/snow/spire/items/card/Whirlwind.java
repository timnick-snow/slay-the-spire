package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Whirlwind extends RedCard {
    private static final String DESC = "对所有敌人造成5点伤害X次。";
    private static final String DESC1 = "对所有敌人造成8点伤害X次。";

    public Whirlwind(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "旋风斩";
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
        return -1;
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
