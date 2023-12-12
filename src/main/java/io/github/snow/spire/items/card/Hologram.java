package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Hologram extends BlueCard {
    private static final String DESC = "获得3点 【格挡】 。将弃牌堆中的一张牌放入你的手牌。 【消耗】 。";
    private static final String DESC1 = "获得5点 【格挡】 。将弃牌堆中的一张牌放入你的手牌。";

    public Hologram(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "全息影像";
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
