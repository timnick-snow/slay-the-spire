package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DevaForm extends PurpleCard {
    private static final String DESC = " 【虚无】 。在你的回合开始时获得[P]，每回合增加1。";
    private static final String DESC1 = "在你的回合开始时获得[P]，每回合增加1。";

    public DevaForm(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "天人形态";
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
