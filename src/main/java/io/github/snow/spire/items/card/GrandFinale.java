package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class GrandFinale extends GreenCard {
    private static final String DESC = "只有当抽牌堆中没有牌时才能打出。对所有敌人造成50点伤害。";
    private static final String DESC1 = "只有当抽牌堆中没有牌时才能打出。对所有敌人造成60点伤害。";

    public GrandFinale(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "华丽收场";
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
