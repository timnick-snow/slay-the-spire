package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Exhume extends RedCard {
    private static final String DESC = "选择一张已 【消耗】 的牌，将其放入你的手牌。 【消耗】 。";
    private static final String DESC1 = "选择一张已 【消耗】 的牌，将其放入你的手牌。 【消耗】 。";

    public Exhume(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "发掘";
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
