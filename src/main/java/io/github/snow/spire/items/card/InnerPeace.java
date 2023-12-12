package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class InnerPeace extends PurpleCard {
    private static final String DESC = " 【平静】 ：抽3张牌。否则，进入 【平静】 。";
    private static final String DESC1 = " 【平静】 ：抽4张牌。否则，进入 【平静】 。";

    public InnerPeace(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "内心宁静";
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
