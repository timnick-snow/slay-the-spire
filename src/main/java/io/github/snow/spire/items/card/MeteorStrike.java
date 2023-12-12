package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class MeteorStrike extends BlueCard {
    private static final String DESC = "造成24点伤害。 【生成】 3个 【等离子】 充能球。";
    private static final String DESC1 = "造成30点伤害。 【生成】 3个 【等离子】 充能球。";

    public MeteorStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "陨石打击";
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
        return 5;
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
