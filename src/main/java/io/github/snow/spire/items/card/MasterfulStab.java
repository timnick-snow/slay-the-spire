package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class MasterfulStab extends GreenCard {
    private static final String DESC = "造成12点伤害。你每次受到伤害，这张牌的耗能增加1。";
    private static final String DESC1 = "造成16点伤害。你每次受到伤害，这张牌的耗能增加1。";

    public MasterfulStab(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "精巧刺击";
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
