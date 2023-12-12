package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WindmillStrike extends PurpleCard {
    private static final String DESC = " 【保留】 。造成7点伤害。每当这张牌被 【保留】 时，将其在本场战斗的伤害增加4点。";
    private static final String DESC1 = " 【保留】 。造成10点伤害。每当这张牌被 【保留】 时，将其在本场战斗的伤害增加5点。";

    public WindmillStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "旋转打击";
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
        return 2;
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
