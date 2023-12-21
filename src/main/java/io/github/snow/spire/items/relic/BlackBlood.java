package io.github.snow.spire.items.relic;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.Characters;
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
 * @since 2023-12-10
 */
public class BlackBlood extends BossRelic implements EffectProducer {
    @Override
    public String displayName() {
        return "黑暗之血";
    }

    @Override
    public String description() {
        return "替换 【燃烧之血】 。在战斗结束时，回复 12点生命。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }


    @Override
    public void onFightEnd(FightContext ctx) {
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
