package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WhiteNoise extends BlueCard {
    private static final String DESC = "增加一张随机能力牌到你的手牌。这张牌在本回合耗能变为0。 【消耗】 。";
    private static final String DESC1 = "增加一张随机能力牌到你的手牌。这张牌在本回合耗能变为0。 【消耗】 。";

    public WhiteNoise(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "白噪声";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
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
