package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DualWield extends RedCard {
    private static final String DESC = "将你手牌中的一张攻击或能力牌复制一张。";
    private static final String DESC1 = "将你手牌中的一张攻击或能力牌复制两张。";

    public DualWield(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双持";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
