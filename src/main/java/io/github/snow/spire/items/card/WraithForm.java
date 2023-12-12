package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WraithForm extends GreenCard {
    private static final String DESC = "获得2层 【无实体】 。在每回合结束时失去1点 【敏捷】 。";
    private static final String DESC1 = "获得3层 【无实体】 。在每回合结束时失去1点 【敏捷】 。";

    public WraithForm(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "幽魂形态";
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
