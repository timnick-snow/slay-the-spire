package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class EchoForm extends BlueCard {
    private static final String DESC = "你每回合打出的第一张牌会打出两次。 【虚无】 。";
    private static final String DESC1 = "你每回合打出的第一张牌会打出两次。";

    public EchoForm(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "回响形态";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return 3;
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
