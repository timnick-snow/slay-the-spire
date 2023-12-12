package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HeelHook extends GreenCard {
    private static final String DESC = "造成5点伤害。如果敌人有 【虚弱】 状态，获得[G]并且抽1张牌。";
    private static final String DESC1 = "造成8点伤害。如果敌人有 【虚弱】 状态，获得[G]并且抽1张牌。";

    public HeelHook(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "足跟勾";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
