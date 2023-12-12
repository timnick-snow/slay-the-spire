package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Barrage extends BlueCard {
    private static final String DESC = "你每拥有一个充能球，造成4点伤害。";
    private static final String DESC1 = "你每拥有一个充能球，造成6点伤害。";

    public Barrage(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "弹幕齐射";
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
