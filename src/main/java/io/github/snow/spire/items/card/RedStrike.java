package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.Collections;
import java.util.List;

/**
 * 打击
 *
 * @author snow
 * @since 2023/12/7
 */
public class RedStrike extends RedCard {
    private static final String DESC = "造成6点伤害。";
    private static final String DESC1 = "造成9点伤害。";

    private int damage = 6;


    public RedStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public String baseName() {
        return "打击";
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
        return 1;
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 9;
    }

    @Override
    public String description() {
        return level == 0 ? DESC : DESC1;
    }

    @Override
    public String upgradeDescription() {
        return DESC1;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, damage, 1);
        damageGroup.setSource(new SourceChain().setFighter(fighter).setProducer(this));
        return Collections.singletonList(damageGroup);
    }
}
