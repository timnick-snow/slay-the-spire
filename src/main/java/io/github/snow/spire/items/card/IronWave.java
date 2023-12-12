package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class IronWave extends RedCard {
    private static final String DESC = "获得5点 【格挡】 。造成5点伤害。";
    private static final String DESC1 = "获得7点 【格挡】 。造成7点伤害。";

    public IronWave(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "铁斩波";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
