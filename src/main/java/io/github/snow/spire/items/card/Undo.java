package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Undo extends BlueCard {
    private static final String DESC = "获得13点 【格挡】 。在本回合 【保留】 你的手牌。";
    private static final String DESC1 = "获得16点 【格挡】 。在本回合 【保留】 你的手牌。";

    public Undo(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "均衡";
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
        return 2;
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
