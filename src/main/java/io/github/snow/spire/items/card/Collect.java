package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Collect extends PurpleCard {
    private static final String DESC = "在你的下X个回合开始时，增加一张 【奇迹|奇迹+】 到你的手牌。 【消耗】 。";
    private static final String DESC1 = "在你的下X+1个回合开始时，增加一张 【奇迹|奇迹+】 到你的手牌。 【消耗】 。";

    public Collect(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "收集";
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
        return -1;
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
