package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SecretWeapon extends ColorlessCard {
    private static final String DESC = "从抽牌堆中选择一张攻击牌放入你的手牌。 【消耗】 。";
    private static final String DESC1 = "从抽牌堆中选择一张攻击牌放入你的手牌。";

    public SecretWeapon(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "秘密武器";
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
