package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CreativeAI extends BlueCard {
    private static final String DESC = "在每回合开始时，增加一张随机能力牌到你的手牌。";
    private static final String DESC1 = "在每回合开始时，增加一张随机能力牌到你的手牌。";

    public CreativeAI(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "创造性AI";
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
