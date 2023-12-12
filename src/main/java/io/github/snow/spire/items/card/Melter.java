package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Melter extends BlueCard {
    private static final String DESC = "去除一名敌人的所有 【格挡】 值。造成10点伤害。";
    private static final String DESC1 = "去除一名敌人的所有 【格挡】 值。造成14点伤害。";

    public Melter(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "熔化";
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
