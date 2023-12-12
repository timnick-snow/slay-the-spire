package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BulletTime extends GreenCard {
    private static final String DESC = "你在本回合内不能再抽牌。你手牌中的所有牌在本回合的耗能变为0点。";
    private static final String DESC1 = "你在本回合内不能再抽牌。你手牌中的所有牌在本回合的耗能变为0点。";

    public BulletTime(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "子弹时间";
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
        return level == 0 ? 3 : 2;
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
