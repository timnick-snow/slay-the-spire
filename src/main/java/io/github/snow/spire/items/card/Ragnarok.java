package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Ragnarok extends PurpleCard {
    private static final String DESC = "随机对敌人造成5点伤害5次。";
    private static final String DESC1 = "随机对敌人造成6点伤害6次。";

    public Ragnarok(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "诸神之黄昏";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.RARE;
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
