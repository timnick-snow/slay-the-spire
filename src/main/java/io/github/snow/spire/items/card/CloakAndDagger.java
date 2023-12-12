package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CloakAndDagger extends GreenCard {
    private static final String DESC = "获得6点 【格挡】 。增加1张 【小刀】 到你的手牌。";
    private static final String DESC1 = "获得6点 【格挡】 。增加2张 【小刀】 到你的手牌。";

    public CloakAndDagger(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "斗篷与匕首";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
