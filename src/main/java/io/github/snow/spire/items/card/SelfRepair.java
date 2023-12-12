package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SelfRepair extends BlueCard {
    private static final String DESC = "在战斗结束时，回复 7 点生命。";
    private static final String DESC1 = "在战斗结束时，回复 10 点生命。";

    public SelfRepair(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "自我修复";
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
