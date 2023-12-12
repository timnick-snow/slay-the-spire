package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Brutality extends RedCard {
    private static final String DESC = "在你的回合开始时，你失去1点生命，抽1张牌。";
    private static final String DESC1 = " 【固有】 。在你的回合开始时，你失去1点生命，抽1张牌。";

    public Brutality(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "残暴";
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
