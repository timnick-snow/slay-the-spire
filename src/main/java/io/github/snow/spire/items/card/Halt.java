package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Halt extends PurpleCard {
    private static final String DESC = "获得3点 【格挡】 。 【愤怒（姿态）|愤怒】 ：获得9点额外格挡。";
    private static final String DESC1 = "获得4点 【格挡】 。 【愤怒（姿态）|愤怒】 ：获得14点额外格挡。";

    public Halt(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "停顿";
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
