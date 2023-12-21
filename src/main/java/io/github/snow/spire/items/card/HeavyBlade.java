package io.github.snow.spire.items.card;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.CardAdder;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HeavyBlade extends RedCard {
    private static final String DESC = "造成14点伤害。 【力量】 在重刃上发挥3倍效果。";
    private static final String DESC1 = "造成14点伤害。 【力量】 在重刃上发挥5倍效果。";

    public HeavyBlade(String id, int level) {
        super(id, level);
    }

    private int multiple = 3;

    @Override
    public void upgrade() {
        super.upgrade();
        this.multiple = 5;
    }

    @Override
    public Card copy(String id) {
        HeavyBlade copy = (HeavyBlade) super.copy(id);
        copy.multiple = multiple;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        int damage = 14;
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        return List.of(damageGroup);
    }

    @Override
    public void onStrengthEffect(ValueWrapper strength, FightContext ctx) {
        strength.setValue(strength.getValue() * multiple);
    }

    @Override
    public String baseName() {
        return "重刃";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
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
