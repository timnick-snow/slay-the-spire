package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DeusExMachina extends PurpleCard {
    private static final String DESC = " 【不能被打出】 。当你抽到这张牌时，在你的手牌中加入2张 【奇迹】 ，然后 【消耗】 。";
    private static final String DESC1 = " 【不能被打出】 。当你抽到这张牌时，在你的手牌中加入3张 【奇迹】 ，然后 【消耗】 。";

    public DeusExMachina(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "机械降神";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return -2;
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
