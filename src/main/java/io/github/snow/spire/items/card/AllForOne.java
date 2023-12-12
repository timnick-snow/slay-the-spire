package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class AllForOne extends BlueCard {
    private static final String DESC = "造成10点伤害。将弃牌堆中所有0耗能的牌放入你的手牌。";
    private static final String DESC1 = "造成14点伤害。将弃牌堆中所有0耗能的牌放入你的手牌。";

    public AllForOne(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "万物一心";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
