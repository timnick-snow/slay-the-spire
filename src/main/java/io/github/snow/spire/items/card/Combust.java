package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Combust extends RedCard {
    private static final String DESC = "在你的回合结束时，你失去1点生命，对所有敌人造成5点伤害。";
    private static final String DESC1 = "在你的回合结束时，你失去1点生命，对所有敌人造成7点伤害。";

    public Combust(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "自燃";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
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
