package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Wallop extends PurpleCard {
    private static final String DESC = "造成9点伤害。获得与所造成的未被格挡的伤害相等的 【格挡】 。";
    private static final String DESC1 = "造成12点伤害。获得与所造成的未被格挡的伤害相等的 【格挡】 。";

    public Wallop(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "当头棒喝";
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
