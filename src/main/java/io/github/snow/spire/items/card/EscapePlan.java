package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class EscapePlan extends GreenCard {
    private static final String DESC = "抽1张牌。如果抽到的是技能牌，获得3点 【格挡】 。";
    private static final String DESC1 = "抽1张牌。如果抽到的是技能牌，获得5点 【格挡】 。";

    public EscapePlan(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "逃脱计划";
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
