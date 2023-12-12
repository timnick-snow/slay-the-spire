package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PanicButton extends ColorlessCard {
    private static final String DESC = "获得30点 【格挡】 。你在接下来2回合内无法再从卡牌中获得格挡。 【消耗】 。";
    private static final String DESC1 = "获得40点 【格挡】 。你在接下来2回合内无法再从卡牌中获得格挡。 【消耗】 。";

    public PanicButton(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "应急按钮";
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
