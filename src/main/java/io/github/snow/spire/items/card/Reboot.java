package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Reboot extends BlueCard {
    private static final String DESC = "将你所有未消耗的牌重新洗牌放入抽牌堆。抽4张牌。 【消耗】 。";
    private static final String DESC1 = "将你所有未消耗的牌重新洗牌放入抽牌堆。抽6张牌。 【消耗】 。";

    public Reboot(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "重启";
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
