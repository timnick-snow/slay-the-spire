package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Hyperbeam extends BlueCard {
    private static final String DESC = "对所有敌人造成26点伤害。失去3点 【集中】 。";
    private static final String DESC1 = "对所有敌人造成34点伤害。失去3点 【集中】 。";

    public Hyperbeam(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "超能光束";
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
