package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Dualcast extends BlueCard {
    private static final String DESC = " 【激发】 你最右侧的充能球2次。";
    private static final String DESC1 = " 【激发】 你最右侧的充能球2次。";

    public Dualcast(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "双重释放";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
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
