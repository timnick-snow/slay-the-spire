package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class MasterReality extends PurpleCard {
    private static final String DESC = "所有在战斗中临时增加的牌将被 【升级】 。";
    private static final String DESC1 = "所有在战斗中临时增加的牌将被 【升级】 。";

    public MasterReality(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "操控现实";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
    }

    @Override
    public int cost() {
        return level == 0 ? 1 : 0;
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
