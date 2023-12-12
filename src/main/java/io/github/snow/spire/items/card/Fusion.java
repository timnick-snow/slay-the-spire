package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Fusion extends BlueCard {
    private static final String DESC = " 【生成】 1个 【等离子】 充能球。";
    private static final String DESC1 = " 【生成】 1个 【等离子】 充能球。";

    public Fusion(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "聚变";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.UNCOMMON;
    }

    @Override
    public int cost() {
        return level == 0 ? 2 : 1;
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
