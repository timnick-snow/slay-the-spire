package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Blur extends GreenCard {
    private static final String DESC = "获得5点 【格挡】 。你的下一回合开始时 【格挡】 不会消失。";
    private static final String DESC1 = "获得8点 【格挡】 。你的下一回合开始时 【格挡】 不会消失。";

    public Blur(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "残影";
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
