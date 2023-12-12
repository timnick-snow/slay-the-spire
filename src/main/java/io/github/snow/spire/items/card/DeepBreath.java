package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DeepBreath extends ColorlessCard {
    private static final String DESC = "将你的弃牌堆洗牌后放入你的抽牌堆。抽1张牌。";
    private static final String DESC1 = "将你的弃牌堆洗牌后放入你的抽牌堆。抽2张牌。";

    public DeepBreath(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "深呼吸";
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
