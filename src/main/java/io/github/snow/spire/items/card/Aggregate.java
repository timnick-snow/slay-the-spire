package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Aggregate extends BlueCard {
    private static final String DESC = "你的抽牌堆中每有4张牌，获得一点[B]。";
    private static final String DESC1 = "你的抽牌堆中每有3张牌，获得一点[B]。";

    public Aggregate(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "汇集";
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
