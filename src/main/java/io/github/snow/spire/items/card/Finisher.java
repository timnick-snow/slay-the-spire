package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Finisher extends GreenCard {
    private static final String DESC = "你在这个回合内每打出过一张攻击牌，就造成一次6点伤害。";
    private static final String DESC1 = "你在这个回合内每打出过一张攻击牌，就造成一次8点伤害。";

    public Finisher(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "终结技";
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
