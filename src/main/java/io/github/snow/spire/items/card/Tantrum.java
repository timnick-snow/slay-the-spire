package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Tantrum extends PurpleCard {
    private static final String DESC = "造成3点伤害3次。进入 【愤怒（姿态）|愤怒】 。将这张牌放入你的抽牌堆。";
    private static final String DESC1 = "造成3点伤害4次。进入 【愤怒（姿态）|愤怒】 。将这张牌放入你的抽牌堆。";

    public Tantrum(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "发泄";
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
