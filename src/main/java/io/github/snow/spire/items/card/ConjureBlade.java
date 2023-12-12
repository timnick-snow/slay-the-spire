package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ConjureBlade extends PurpleCard {
    private static final String DESC = "将1张  【灭除之刃】 放入你的抽牌堆中。 【消耗】 。";
    private static final String DESC1 = "将1张X数值+1的 【灭除之刃】 放入你的抽牌堆中。 【消耗】 。";

    public ConjureBlade(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "聚能成刃";
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
        return -1;
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
