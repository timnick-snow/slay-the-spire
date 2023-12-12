package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Judgment extends PurpleCard {
    private static final String DESC = "如果目标敌人的生命值小于等于30点，则将其生命值变为0。";
    private static final String DESC1 = "如果目标敌人的生命值小于等于40点，则将其生命值变为0。";

    public Judgment(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "审判";
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
