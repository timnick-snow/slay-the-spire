package io.github.snow.spire.items.card;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Clash extends RedCard {
    private static final String DESC = "只有在手牌每一张牌都是攻击牌时才能被打出。造成14点伤害。";
    private static final String DESC1 = "只有在手牌每一张牌都是攻击牌时才能被打出。造成18点伤害。";

    public Clash(String id, int level) {
        super(id, level);
    }

    private int damage = 14;

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 18;
    }

    @Override
    public Card copy(String id) {
        Clash copy = (Clash) super.copy(id);
        copy.damage = this.damage;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        return List.of(damageGroup);
    }

    @Override
    public boolean isPlayable(FightContext ctx) {
        return ctx.getHand().stream().allMatch(card -> card.type() == CardType.ATTACK);
    }

    @Override
    public String baseName() {
        return "交锋";
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
        return 0;
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
