package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Rushdown extends PurpleCard {
    private static final String DESC = "每当你进入 【愤怒（姿态）|愤怒】 时，抽2张牌。";
    private static final String DESC1 = "每当你进入 【愤怒（姿态）|愤怒】 时，抽2张牌。";

    public Rushdown(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "猛虎下山";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 1 : 0;
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
