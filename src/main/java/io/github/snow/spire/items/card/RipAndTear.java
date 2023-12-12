package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class RipAndTear extends BlueCard {
    private static final String DESC = "随机对敌人造成7点伤害2次。";
    private static final String DESC1 = "随机对敌人造成9点伤害2次。";

    public RipAndTear(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "狂乱撕扯";
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
