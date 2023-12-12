package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DeceiveReality extends PurpleCard {
    private static final String DESC = "获得4点 【格挡】 。将一张 【平安】 加入你的手牌。";
    private static final String DESC1 = "获得7点 【格挡】 。将一张 【平安】 加入你的手牌。";

    public DeceiveReality(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "欺瞒现实";
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
