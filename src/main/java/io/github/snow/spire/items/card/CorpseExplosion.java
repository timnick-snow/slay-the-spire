package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CorpseExplosion extends GreenCard {
    private static final String DESC = "给予6层 【中毒】 。 当这名敌人死亡时，对所有敌人造成等于其最大生命值的伤害。";
    private static final String DESC1 = "给予9层 【中毒】 。当这名敌人死亡时，对所有敌人造成等于其最大生命值的伤害。";

    public CorpseExplosion(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "尸爆术";
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
