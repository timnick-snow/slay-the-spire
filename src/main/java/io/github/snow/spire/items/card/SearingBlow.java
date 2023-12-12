package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SearingBlow extends RedCard {
    private static final String DESC = "造成12点伤害。能被多次 【升级】 。";
    private static final String DESC1 = "造成16点伤害。能被多次 【升级】 。";

    public SearingBlow(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "灼热攻击";
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
