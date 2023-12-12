package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Eviscerate extends GreenCard {
    private static final String DESC = "你在这个回合内每丢弃一张牌，耗能就减少1[G]。造成7点伤害三次。";
    private static final String DESC1 = "你在这个回合内每丢弃一张牌，耗能就减少1[G]。造成9点伤害三次。";

    public Eviscerate(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "内脏切除";
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
        return 3;
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
