package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class FireBreathing extends RedCard {
    private static final String DESC = "当你抽到一张 【状态牌】 或 【诅咒】 牌时，对所有敌人造成6点伤害。";
    private static final String DESC1 = "当你抽到一张 【状态牌】 或 【诅咒】 牌时，对所有敌人造成10点伤害。";

    public FireBreathing(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "火焰吐息";
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
