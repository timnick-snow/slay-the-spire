package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CoreSurge extends BlueCard {
    private static final String DESC = "造成11点伤害。获得1层 【人工制品】 。 【消耗】 。";
    private static final String DESC1 = "造成15点伤害。获得1层 【人工制品】 。 【消耗】 。";

    public CoreSurge(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "核心电涌";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
