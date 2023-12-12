package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DodgeAndRoll extends GreenCard {
    private static final String DESC = "获得4点 【格挡】 。在下一回合获得4点 【格挡】 。";
    private static final String DESC1 = "获得6点 【格挡】 。在下一回合获得6点 【格挡】 。";

    public DodgeAndRoll(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "闪躲翻滚";
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
