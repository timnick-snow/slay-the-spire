package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Conclude extends PurpleCard {
    private static final String DESC = "对所有敌人造成12点伤害。结束你的回合。";
    private static final String DESC1 = "对所有敌人造成16点伤害。结束你的回合。";

    public Conclude(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "结末";
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
