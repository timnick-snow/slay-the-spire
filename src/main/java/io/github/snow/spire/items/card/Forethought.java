package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Forethought extends ColorlessCard {
    private static final String DESC = "将手牌中的一张牌放到抽牌堆的底部。并且这张牌在被打出之前，耗能变为0。";
    private static final String DESC1 = "将手牌中的任意张牌放到抽牌堆的底部。并且它们被打出之前，耗能变为0。";

    public Forethought(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "预谋";
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
        return 0;
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
