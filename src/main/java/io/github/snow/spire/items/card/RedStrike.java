package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * 打击
 *
 * @author snow
 * @since 2023/12/7
 */
public class RedStrike extends RedCard {
    private static final String DESC = "造成6点伤害。";
    private static final String DESC1 = "造成9点伤害。";

    public RedStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return  "打击";
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
        return 1;
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
