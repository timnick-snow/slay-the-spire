package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Indignation extends PurpleCard {
    private static final String DESC = " 【愤怒（姿态）|愤怒】 ：给予所有敌人3层 【易伤】 。否则，进入 【愤怒（姿态）|愤怒】 。";
    private static final String DESC1 = " 【愤怒（姿态）|愤怒】 ：给予所有敌人5层 【易伤】 。否则，进入 【愤怒（姿态）|愤怒】 。";

    public Indignation(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "义愤填膺";
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
