package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class LessonLearned extends PurpleCard {
    private static final String DESC = "造成10点伤害。 【斩杀】 时， 【升级】 你牌组中的一张随机牌。 【消耗】 。";
    private static final String DESC1 = "造成13点伤害。 【斩杀】 时， 【升级】 你牌组中的一张随机牌。 【消耗】 。";

    public LessonLearned(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "勤学精进";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
