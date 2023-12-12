package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Unload extends GreenCard {
    private static final String DESC = "造成14点伤害。丢弃所有非攻击牌。";
    private static final String DESC1 = "造成18点伤害。丢弃所有非攻击牌。";

    public Unload(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "乾坤一掷";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
