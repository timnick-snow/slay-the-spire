package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ColdSnap extends BlueCard {
    private static final String DESC = "造成6点伤害。 【生成】 1个 【冰霜】 充能球。";
    private static final String DESC1 = "造成9点伤害。 【生成】 1个 【冰霜】 充能球。";

    public ColdSnap(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "寒流";
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
