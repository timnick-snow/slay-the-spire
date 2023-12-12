package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class DoomAndGloom extends BlueCard {
    private static final String DESC = "对所有敌人造成10点伤害。 【生成】 1个 【黑暗】 充能球。";
    private static final String DESC1 = "对所有敌人造成14点伤害。 【生成】 1个 【黑暗】 充能球。";

    public DoomAndGloom(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "愁云惨淡";
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
        return 2;
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
