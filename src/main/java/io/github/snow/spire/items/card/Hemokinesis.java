package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Hemokinesis extends RedCard {
    private static final String DESC = "失去2点生命。造成15点伤害。";
    private static final String DESC1 = "失去2点生命。造成20点伤害。";

    public Hemokinesis(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "御血术";
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
