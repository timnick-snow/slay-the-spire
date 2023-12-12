package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class AutoShields extends BlueCard {
    private static final String DESC = "如果你没有格挡，获得 11 点 【格挡】 。";
    private static final String DESC1 = "如果你没有格挡，获得15点 【格挡】 。";

    public AutoShields(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "自动护盾";
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
