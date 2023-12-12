package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ForceField extends BlueCard {
    private static final String DESC = "你在本场战斗中每打出一张能力牌，耗能就减少1[B]。获得12点 【格挡】 。";
    private static final String DESC1 = "你在本场战斗中每打出一张能力牌，耗能就减少1[B]。获得16点 【格挡】 。";

    public ForceField(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "力场";
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
        return 4;
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
