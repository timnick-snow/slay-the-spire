package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HelloWorld extends BlueCard {
    private static final String DESC = "在你的回合开始时，增加一张随机普通牌到你的手牌。";
    private static final String DESC1 = " 【固有】 。在你的回合开始时，增加一张随机普通牌到你的手牌。";

    public HelloWorld(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "你好，世界";
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
