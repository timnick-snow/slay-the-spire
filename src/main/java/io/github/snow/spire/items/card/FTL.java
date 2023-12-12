package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FTL extends BlueCard {
    private static final String DESC = "造成5点伤害。如果你在这回合打出的牌数少于3张，抽一张牌。";
    private static final String DESC1 = "造成6点伤害。如果你在这回合打出的牌数少于4张，抽一张牌。";

    public FTL(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "超越光速";
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
