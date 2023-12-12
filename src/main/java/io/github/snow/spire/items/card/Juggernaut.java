package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Juggernaut extends RedCard {
    private static final String DESC = "每当你获得 【格挡】 时，对随机一名敌人造成5点伤害。";
    private static final String DESC1 = "每当你获得 【格挡】 时，对随机一名敌人造成7点伤害。";

    public Juggernaut(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "势不可当";
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
