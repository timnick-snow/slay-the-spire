package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FlameBarrier extends RedCard {
    private static final String DESC = "获得12点 【格挡】 。你在这个回合每受到一次攻击，都对攻击者造成4点伤害。";
    private static final String DESC1 = "获得16点 【格挡】 。你在这个回合每受到一次攻击，都对攻击者造成6点伤害。";

    public FlameBarrier(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "火焰屏障";
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
