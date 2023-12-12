package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Barricade extends RedCard {
    private static final String DESC = " 【格挡】 不再在你的回合开始时消失。";
    private static final String DESC1 = " 【格挡】 不再在你的回合开始时消失。";

    public Barricade(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "壁垒";
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
        return level == 0 ? 3 : 2;
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
