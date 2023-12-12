package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Eruption extends PurpleCard {
    private static final String DESC = "造成9点伤害。进入 【愤怒（姿态）|愤怒】 。";
    private static final String DESC1 = "造成9点伤害。进入 【愤怒（姿态）|愤怒】 。";

    public Eruption(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "暴怒";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
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
