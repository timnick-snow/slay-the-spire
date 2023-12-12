package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class NightTerror extends GreenCard {
    private static final String DESC = "选择一张牌， 在下一回合，将 3 份这张牌的复制品放入你的手牌中。 【消耗】 。";
    private static final String DESC1 = "选择一张牌， 在下一回合，将 3 份这张牌的复制品放入你的手牌中。 【消耗】 。";

    public NightTerror(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "夜魇";
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
        return level == 0 ? 3 : 2;
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
