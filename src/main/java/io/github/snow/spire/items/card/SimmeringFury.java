package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SimmeringFury extends PurpleCard {
    private static final String DESC = "在你的下一回合开始时，进入 【愤怒（姿态）|愤怒】 并抽2张牌。";
    private static final String DESC1 = "在你的下一回合开始时，进入 【愤怒（姿态）|愤怒】 并抽3张牌。";

    public SimmeringFury(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "怒火中烧";
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
