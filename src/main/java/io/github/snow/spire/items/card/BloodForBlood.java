package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BloodForBlood extends RedCard {
    private static final String DESC = "你每在战斗中失去生命一次，这张牌的耗能就减少1[R]。造成18点伤害。";
    private static final String DESC1 = "你每在战斗中失去生命一次，这张牌的耗能就减少1[R]。造成22点伤害。";

    public BloodForBlood(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "以血还血";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 4 : 3;
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
