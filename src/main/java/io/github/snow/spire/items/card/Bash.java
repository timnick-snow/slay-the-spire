package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.debuff.Vulnerable;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Bash extends RedCard {
    private static final String DESC = "造成8点伤害。给予2层 【易伤】 。";
    private static final String DESC1 = "造成10点伤害。给予3层 【易伤】 。";

    private int damage = 8;
    private int vulnerable = 2;

    public Bash(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 10;
        this.vulnerable = 3;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, damage, 1);
        damageGroup.setSource(new SourceChain().setFighter(fighter).setProducer(this));
        // 易伤
        PowerAdder powerAdder = new PowerAdder(EffectTarget.SINGLE_OPPONENT, new Vulnerable(vulnerable));
        powerAdder.setSource(new SourceChain().setFighter(fighter).setProducer(this));
        return List.of(damageGroup, powerAdder);
    }

    @Override
    public String baseName() {
        return "痛击";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
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
