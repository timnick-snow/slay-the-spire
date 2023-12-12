package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Blizzard extends BlueCard {
    private static final String DESC = "对所有敌人造成你在本场战斗中 【生成】 过的 【冰霜】 充能球总数2倍的伤害。";
    private static final String DESC1 = "对所有敌人造成你在本场战斗中 【生成】 过的 【冰霜】 充能球总数3倍的伤害。";

    public Blizzard(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "暴雪";
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
