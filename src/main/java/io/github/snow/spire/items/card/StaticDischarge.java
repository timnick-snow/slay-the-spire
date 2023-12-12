package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class StaticDischarge extends BlueCard {
    private static final String DESC = "每当你受到攻击伤害时， 【生成】 1个 【闪电】 充能球。";
    private static final String DESC1 = "每当你受到攻击伤害时， 【生成】 2个 【闪电】 充能球。";

    public StaticDischarge(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "静电释放";
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
