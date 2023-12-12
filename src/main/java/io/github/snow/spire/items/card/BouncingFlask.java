package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BouncingFlask extends GreenCard {
    private static final String DESC = "随机给予敌人3层 【中毒】 3次。";
    private static final String DESC1 = "随机给予敌人3层 【中毒】 4次。";

    public BouncingFlask(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "弹跳药瓶";
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
