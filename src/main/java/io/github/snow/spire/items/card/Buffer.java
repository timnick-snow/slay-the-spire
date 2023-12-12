package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Buffer extends BlueCard {
    private static final String DESC = "阻止下一次你受到的生命值损伤。";
    private static final String DESC1 = "阻止下2次你受到的生命值损伤。";

    public Buffer(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "缓冲";
    }

    @Override
    public CardType type() {
        return CardType.POWER;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
