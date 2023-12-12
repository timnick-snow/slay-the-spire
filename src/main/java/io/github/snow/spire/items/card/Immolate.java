package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Immolate extends RedCard {
    private static final String DESC = "对所有敌人造成21点伤害。将一张 【灼伤】 放入你的弃牌堆中。";
    private static final String DESC1 = "对所有敌人造成28点伤害。将一张 【灼伤】 放入你的弃牌堆中。";

    public Immolate(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "燔祭";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return 2;
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
