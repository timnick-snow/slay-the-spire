package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class PerfectedStrike extends RedCard {
    private static final String DESC = "造成6点伤害。你每有一张名字中有 【打击】 的牌，伤害+2。";
    private static final String DESC1 = "造成6点伤害。你每有一张名字中有 【打击】 的牌，伤害+3。";

    public PerfectedStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "完美打击";
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
