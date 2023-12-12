package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Accuracy extends GreenCard {
    private static final String DESC = " 【小刀】 造成的伤害增加4。";
    private static final String DESC1 = " 【小刀】 造成的伤害增加6。";

    public Accuracy(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "精准";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
