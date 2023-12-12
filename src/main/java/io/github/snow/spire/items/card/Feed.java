package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Feed extends RedCard {
    private static final String DESC = "造成10点伤害。若 【斩杀】 ，则永久获得3点最大生命。 【消耗】 。";
    private static final String DESC1 = "造成12点伤害。若 【斩杀】 ，则永久获得4点最大生命。 【消耗】 。";

    public Feed(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "狂宴";
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
