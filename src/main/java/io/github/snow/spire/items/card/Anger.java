package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Anger extends RedCard {
    private static final String DESC = "造成6点伤害。在弃牌堆放入一张此牌的复制品。";
    private static final String DESC1 = "造成8点伤害。在弃牌堆放入一张此牌的复制品。";

    public Anger(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "愤怒";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
