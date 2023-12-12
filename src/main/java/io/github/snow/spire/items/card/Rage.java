package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Rage extends RedCard {
    private static final String DESC = "打出此牌后，你在这个回合内每打出一张攻击牌，获得3 【格挡】 。";
    private static final String DESC1 = "打出此牌后，你在这个回合内每打出一张攻击牌，获得5 【格挡】 。";

    public Rage(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "狂怒";
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
