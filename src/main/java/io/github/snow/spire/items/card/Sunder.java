package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Sunder extends BlueCard {
    private static final String DESC = "造成24点伤害。如果这张牌杀死了敌人，则获得[B][B][B]。";
    private static final String DESC1 = "造成32点伤害。如果这张牌杀死了敌人，则获得[B][B][B] 。";

    public Sunder(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "分离";
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
        return 3;
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
