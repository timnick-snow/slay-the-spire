package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BattleTrance extends RedCard {
    private static final String DESC = "抽3张牌。你在这个回合内不能再抽任何牌。";
    private static final String DESC1 = "抽4张牌。你在这个回合内不能再抽任何牌。";

    public BattleTrance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "战斗专注";
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
        return 0;
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
