package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Omniscience extends PurpleCard {
    private static final String DESC = "选择你抽牌堆中的一张牌。将这张牌打出两次然后将其 【消耗】 。 【消耗】 。";
    private static final String DESC1 = "选择你抽牌堆中的一张牌。将这张牌打出两次然后将其 【消耗】 。 【消耗】 。";

    public Omniscience(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "通晓万物";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return level == 0 ? 4 : 3;
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
