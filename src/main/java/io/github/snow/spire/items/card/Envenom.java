package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Envenom extends GreenCard {
    private static final String DESC = "每有一次攻击造成未被格挡的伤害，就给予1层 【中毒】 。";
    private static final String DESC1 = "每有一次攻击造成未被格挡的伤害，就给予1层 【中毒】 。";

    public Envenom(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "涂毒";
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
        return level == 0 ? 2 : 1;
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
