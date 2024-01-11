package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class TwinStrike extends RedCard implements StrikeAware {
    private static final String DESC = "造成5点伤害两次。";
    private static final String DESC1 = "造成7点伤害两次。";

    public TwinStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双重打击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
