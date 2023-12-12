package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class LikeWater extends PurpleCard {
    private static final String DESC = "在你的回合结束时，如果你处于 【平静】 ，则获得5点 【格挡】 。";
    private static final String DESC1 = "在你的回合结束时，如果你处于 【平静】 ，则获得7点 【格挡】 。";

    public LikeWater(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "如水";
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
