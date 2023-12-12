package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Coolheaded extends BlueCard {
    private static final String DESC = " 【生成】 1个 【冰霜】 充能球。抽1张牌。";
    private static final String DESC1 = " 【生成】 1个 【冰霜】 充能球。抽2张牌。";

    public Coolheaded(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "冷静头脑";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
