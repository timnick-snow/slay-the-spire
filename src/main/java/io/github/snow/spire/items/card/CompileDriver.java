package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class CompileDriver extends BlueCard {
    private static final String DESC = "造成7点伤害。你每有一种不同的充能球，抽1张牌。";
    private static final String DESC1 = "造成10点伤害。你每有一种不同的充能球，抽1张牌。";

    public CompileDriver(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "编译冲击";
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
