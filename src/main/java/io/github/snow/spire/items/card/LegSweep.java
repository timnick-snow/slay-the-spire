package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class LegSweep extends GreenCard {
    private static final String DESC = "给予2层虚弱。获得11点 【格挡】 。";
    private static final String DESC1 = "给予3层虚弱。获得14点 【格挡】 。";

    public LegSweep(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "扫腿";
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
