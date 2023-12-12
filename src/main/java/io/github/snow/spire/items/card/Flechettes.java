package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Flechettes extends GreenCard {
    private static final String DESC = "手牌中每有一张技能牌，造成4点伤害。";
    private static final String DESC1 = "手牌中每有一张技能牌，造成6点伤害。";

    public Flechettes(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "飞镖";
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
