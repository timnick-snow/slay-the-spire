package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class WreathOfFlame extends PurpleCard {
    private static final String DESC = "你的下一张攻击牌造成5点额外伤害。";
    private static final String DESC1 = "你的下一张攻击牌造成8点额外伤害。";

    public WreathOfFlame(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "火焰纹";
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
