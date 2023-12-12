package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SeverSoul extends RedCard {
    private static final String DESC = " 【消耗】 手牌中所有非攻击牌。造成16点伤害。";
    private static final String DESC1 = " 【消耗】 手牌中所有非攻击牌。造成22点伤害。";

    public SeverSoul(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "断魂斩";
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
