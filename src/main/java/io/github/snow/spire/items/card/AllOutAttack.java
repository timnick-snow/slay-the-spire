package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class AllOutAttack extends GreenCard {
    private static final String DESC = "对所有敌人造成10点伤害。丢弃一张随机手牌。";
    private static final String DESC1 = "对所有敌人造成14点伤害。丢弃一张随机手牌。";

    public AllOutAttack(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "全力攻击";
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
