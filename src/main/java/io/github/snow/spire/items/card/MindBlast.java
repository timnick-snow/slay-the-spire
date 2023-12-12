package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class MindBlast extends ColorlessCard {
    private static final String DESC = " 【固有】 。造成你抽牌堆中剩余牌数的伤害。";
    private static final String DESC1 = " 【固有】 。造成你抽牌堆中剩余牌数的伤害。";

    public MindBlast(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "心灵震慑";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 2 : 1;
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
