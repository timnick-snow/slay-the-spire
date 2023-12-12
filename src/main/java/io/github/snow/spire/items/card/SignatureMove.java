package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SignatureMove extends PurpleCard {
    private static final String DESC = "只有当这张牌是你手中唯一的一张攻击牌时才可以被打出。造成30点伤害。";
    private static final String DESC1 = "只有当这张牌是你手中唯一的一张攻击牌时才可以被打出。造成40点伤害。";

    public SignatureMove(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "招牌技";
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
