package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Swivel extends PurpleCard {
    private static final String DESC = "获得8点 【格挡】 。你打出的下一张攻击牌耗能变为0。";
    private static final String DESC1 = "获得11点 【格挡】 。你打出的下一张攻击牌耗能变为0。";

    public Swivel(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "旋身";
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
