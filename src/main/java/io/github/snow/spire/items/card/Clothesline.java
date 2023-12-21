package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.debuff.Weak;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Clothesline extends RedCard {
    private static final String DESC = "造成12点伤害。给予2层 【虚弱】 。";
    private static final String DESC1 = "造成14点伤害。给予3层 【虚弱】 。";

    private int damage = 12;
    private int weak = 2;

    public Clothesline(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 14;
        this.weak = 3;
    }

    @Override
    public Card copy(String id) {
        Clothesline copy = (Clothesline) super.copy(id);
        copy.damage = this.damage;
        copy.weak = this.weak;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        // 虚弱
        PowerAdder powerAdder = new PowerAdder(EffectTarget.SINGLE_OPPONENT, source.copy(), new Weak(weak));
        return List.of(damageGroup, powerAdder);
    }

    @Override
    public String baseName() {
        return "金刚臂";
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
