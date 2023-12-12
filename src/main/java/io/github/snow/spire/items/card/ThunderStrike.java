package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ThunderStrike extends BlueCard {
    private static final String DESC = "你在本场战斗中每 【生成】 过一个 【闪电】 充能球，随机造成一次7点伤害。";
    private static final String DESC1 = "你在本场战斗中每 【生成】 过一个 【闪电】 充能球，随机造成一次9点伤害。";

    public ThunderStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "雷霆打击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
