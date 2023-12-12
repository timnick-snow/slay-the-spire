package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Carnage extends RedCard {
    private static final String DESC = " 【虚无】 。造成20点伤害。";
    private static final String DESC1 = " 【虚无】 。造成28点伤害。";

    public Carnage(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "残杀";
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
