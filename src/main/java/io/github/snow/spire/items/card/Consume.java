package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Consume extends BlueCard {
    private static final String DESC = "获得2点 【集中】 。失去1个充能球栏位。";
    private static final String DESC1 = "获得3点 【集中】 。失去1个充能球栏位。";

    public Consume(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "耗尽";
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
