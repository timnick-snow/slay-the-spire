package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Lockon extends BlueCard {
    private static final String DESC = "造成8点伤害。给予敌人2回合 【跟踪锁定】 效果。";
    private static final String DESC1 = "造成11点伤害。给予敌人3回合 【跟踪锁定】 效果。";

    public Lockon(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "瞄准靶心";
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
