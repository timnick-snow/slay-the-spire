package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SpiritShield extends PurpleCard {
    private static final String DESC = "你每有一张手牌，获得3点 【格挡】 。";
    private static final String DESC1 = "你每有一张手牌，获得4点 【格挡】 。";

    public SpiritShield(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "精神护盾";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
