package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.Heal;
import io.github.snow.spire.items.player.Player;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/9
 */
public class BloodVial extends CommonRelic implements EffectProducer {
    @Override
    public String displayName() {
        return "小血瓶";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，回复 2 点生命。";
    }

    @Override
    public void onFightStart(FightContext ctx) {
        Player player = ctx.getPlayer();
        Effect<?> effect = getRoughEffect(player).getFirst()
                .process(List.of(player));
        ctx.addEffectTail(effect);
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        Heal heal = new Heal(12, source);
        return List.of(heal);
    }
}
