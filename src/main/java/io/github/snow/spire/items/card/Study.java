package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Study extends PurpleCard {
    private static final String DESC = "在你的回合结束时，在你的抽牌堆中加入一张 【洞见】 。";
    private static final String DESC1 = "在你的回合结束时，在你的抽牌堆中加入一张 【洞见】 。";

    public Study(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "研习";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 2 : 1;
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
