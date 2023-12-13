package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;

/**
 * @author snow
 * @since 2023/12/12
 */
public class SearingBlow extends RedCard {
    private static final String TEMPLATE = "造成%s点伤害。能被多次 【升级】 。";

    private int damage = 12;

    public SearingBlow(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "灼热攻击";
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
    public void upgrade() {
        super.upgrade();
        this.damage = calcDamage(level);
    }

    @Override
    public String description() {
        return TEMPLATE.formatted(damage);
    }

    @Override
    public String upgradeDescription() {
        return TEMPLATE.formatted(calcDamage(level + 1));
    }

    @Override
    public boolean isUpgradable() {
        return true;
    }

    private int calcDamage(int n) {
        return n * (n + 7) / 2 + 12;
    }
}
