package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Fission extends BlueCard {
    private static final String DESC = "移除所有充能球，每移除一个充能球获得[B]并抽1张牌。 【消耗】  。";
    private static final String DESC1 = " 【激发】 所有充能球，每激发一个充能球获得[B]并抽1张牌。 【消耗】  。";

    public Fission(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "裂变";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
