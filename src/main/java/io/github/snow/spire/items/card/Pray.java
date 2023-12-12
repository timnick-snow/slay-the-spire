package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Pray extends PurpleCard {
    private static final String DESC = "获得3层 【真言】 。在你的抽牌堆中加入1张 【洞见】 。";
    private static final String DESC1 = "获得4层 【真言】 。在你的抽牌堆中加入1张 【洞见】 。";

    public Pray(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "祈祷";
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
