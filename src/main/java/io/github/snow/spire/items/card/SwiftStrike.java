package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SwiftStrike extends ColorlessCard {
    private static final String DESC = "造成7点伤害。";
    private static final String DESC1 = "造成10点伤害。";

    public SwiftStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "迅捷打击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
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
