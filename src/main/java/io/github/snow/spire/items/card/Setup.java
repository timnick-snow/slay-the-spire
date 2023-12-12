package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Setup extends GreenCard {
    private static final String DESC = "将手牌中的一张牌放到抽牌堆的顶部。并且在其被打出之前，其耗能变为0。";
    private static final String DESC1 = "将手牌中的一张牌放到抽牌堆的顶部。并且在其被打出之前，其耗能变为0。";

    public Setup(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "部署";
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
