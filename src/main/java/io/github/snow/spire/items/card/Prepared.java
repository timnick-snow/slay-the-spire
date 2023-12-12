package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Prepared extends GreenCard {
    private static final String DESC = "抽1张牌。丢弃1张牌。";
    private static final String DESC1 = "抽2张牌。丢弃2张牌。";

    public Prepared(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "早有准备";
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
