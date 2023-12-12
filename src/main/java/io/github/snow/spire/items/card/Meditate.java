package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Meditate extends PurpleCard {
    private static final String DESC = "将弃牌堆中的1张牌放入你的手牌，并将其 【保留】 。进入[ 【平静】 。结束你的回合。";
    private static final String DESC1 = "将弃牌堆中的2张牌放入你的手牌，并将它们 【保留】 。进入 【平静】 。结束你的回合。";

    public Meditate(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "冥想";
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
