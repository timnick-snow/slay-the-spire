package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Redo extends BlueCard {
    private static final String DESC = " 【激发】 你最右侧的充能球。然后 【生成】 一个刚才被 【激发】 的充能球。";
    private static final String DESC1 = " 【激发】 你最右侧的充能球。然后 【生成】 一个刚才被 【激发】 的充能球。";

    public Redo(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "递归";
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
        return level == 0 ? 1 : 0;
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
