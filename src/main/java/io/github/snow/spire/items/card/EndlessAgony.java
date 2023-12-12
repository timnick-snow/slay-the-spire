package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class EndlessAgony extends GreenCard {
    private static final String DESC = "造成4点伤害。每当你抽到这张牌，都增加一张其复制品到你的手牌。 【消耗】 。";
    private static final String DESC1 = "造成6点伤害。每当你抽到这张牌，都增加一张其复制品到你的手牌。 【消耗】 。";

    public EndlessAgony(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "无尽苦痛";
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
