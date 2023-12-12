package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DoubleTap extends RedCard {
    private static final String DESC = "在这个回合，你打出的下一张攻击牌会打出两次。";
    private static final String DESC1 = "在这个回合，你打出的下2张攻击牌会打出两次。";

    public DoubleTap(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双发";
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
