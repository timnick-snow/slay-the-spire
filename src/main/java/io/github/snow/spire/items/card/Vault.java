package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Vault extends PurpleCard {
    private static final String DESC = "在本回合结束后，额外获得一回合。结束你的回合。 【消耗】 。";
    private static final String DESC1 = "在本回合结束后，额外获得一回合。结束你的回合。 【消耗】 。";

    public Vault(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "腾跃";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return level == 0 ? 3 : 2;
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
