package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WaveOfTheHand extends PurpleCard {
    private static final String DESC = "在本回合，你每次获得 【格挡】 时，给予所有敌人1层 【虚弱】 。";
    private static final String DESC1 = "在本回合，你每次获得 【格挡】 时，给予所有敌人2层 【虚弱】 。";

    public WaveOfTheHand(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "摆手";
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
