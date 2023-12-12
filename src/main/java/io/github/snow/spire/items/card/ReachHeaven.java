package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ReachHeaven extends PurpleCard {
    private static final String DESC = "造成10点伤害。在你的抽牌堆中加入1张 【以暴易暴】 。";
    private static final String DESC1 = "造成15点伤害。在你的抽牌堆中加入1张 【以暴易暴】 。";

    public ReachHeaven(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "立地升天";
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
