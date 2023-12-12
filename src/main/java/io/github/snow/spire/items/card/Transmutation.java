package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Transmutation extends ColorlessCard {
    private static final String DESC = "在你的手牌中加入X张随机无色牌。它们在本回合的耗能变为0。 【消耗】 。";
    private static final String DESC1 = "在你的手牌中放入X张 【升级】 过的随机无色牌。它们在本回合的耗能变为0。 【消耗】 。";

    public Transmutation(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "转化";
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
