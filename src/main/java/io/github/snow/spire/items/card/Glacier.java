package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Glacier extends BlueCard {
    private static final String DESC = "获得7点 【格挡】 。 【生成】 2个 【冰霜】 充能球。";
    private static final String DESC1 = "获得10点 【格挡】 。 【生成】 2个 【冰霜】 充能球。";

    public Glacier(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "冰川";
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
