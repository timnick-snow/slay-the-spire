package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Brilliance extends PurpleCard {
    private static final String DESC = "造成12点伤害。额外造成本场战斗中获得的 【真言】 总层数的伤害。";
    private static final String DESC1 = "造成16点伤害。额外造成本场战斗中获得的 【真言】 总层数的伤害。";

    public Brilliance(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "光辉";
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
