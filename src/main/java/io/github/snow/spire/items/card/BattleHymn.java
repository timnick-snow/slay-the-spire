package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class BattleHymn extends PurpleCard {
    private static final String DESC = "在每回合开始时，将一张 【惩恶】 加入你的手牌。";
    private static final String DESC1 = " 【固有】 。在每回合开始时，将一张 【惩恶】 加入你的手牌。";

    public BattleHymn(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "战歌";
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
