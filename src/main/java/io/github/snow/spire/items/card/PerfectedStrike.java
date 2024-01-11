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
public class PerfectedStrike extends RedCard implements StrikeAware {
    private static final String DESC = "造成6点伤害。你每有一张名字中有 【打击】 的牌，伤害+2。";
    private static final String DESC1 = "造成6点伤害。你每有一张名字中有 【打击】 的牌，伤害+3。";

    private final int damage = 6;

    public PerfectedStrike(String id, int level) {
        super(id, level);
    }

    @Override
    public void onAttack(DamageGroup damageGroup, FightContext ctx) {
        int counted = ctx.countStrike();
        int added = (level > 0 ? 3 : 2) * counted;
        damageGroup.setBase(damage + added);
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        return List.of(damageGroup);
    }

    @Override
    public String baseName() {
        return "完美打击";
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
