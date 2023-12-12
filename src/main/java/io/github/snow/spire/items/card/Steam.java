package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Steam extends BlueCard {
    private static final String DESC = "获得6点 【格挡】 。这张牌每被打出一次，它在本场战斗中的基础格挡下降1。";
    private static final String DESC1 = "获得8点 【格挡】 。这张牌每被打出一次，它在本场战斗中的基础格挡下降1。";

    public Steam(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "蒸汽护壁";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
