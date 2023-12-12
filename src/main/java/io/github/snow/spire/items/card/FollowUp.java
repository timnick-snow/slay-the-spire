package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FollowUp extends PurpleCard {
    private static final String DESC = "造成7点伤害。如果本场战斗中打出的上一张牌是攻击牌，获得{{能量|紫}}。";
    private static final String DESC1 = "造成11点伤害。如果本场战斗中打出的上一张牌是攻击牌，获得{{能量|紫}}。";

    public FollowUp(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "追击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
