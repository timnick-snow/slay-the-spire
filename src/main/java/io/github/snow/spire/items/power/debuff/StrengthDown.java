package io.github.snow.spire.items.power.debuff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.Player;
import io.github.snow.spire.items.power.BasePower;
import io.github.snow.spire.items.power.Strength;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class StrengthDown extends BasePower implements EffectProducer {
    private boolean alive;

    public StrengthDown(int num) {
        super(num);
        this.alive = true;
    }

    @Override
    public void onPlayerRoundEnd(FightContext ctx) {
        if (alive && host instanceof Player) {
            Effect<?> effect = getRoughEffect(host).getFirst()
                    .process(List.of(host));
            ctx.addEffectTail(effect);

            this.alive = false;
            host.powerRefresh();
        }
    }

    @Override
    public void onEnemyRoundEnd(FightContext ctx) {
        if (alive && host instanceof Enemy) {
            Effect<?> effect = getRoughEffect(host).getFirst()
                    .process(List.of(host));
            ctx.addEffectTail(effect);

            this.alive = false;
            host.powerRefresh();
        }
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        PowerAdder powerAdder = new PowerAdder(EffectTarget.SELF, source, new Strength(-num));
        return List.of(powerAdder);
    }

    @Override
    public String name() {
        return "活动肌肉";
    }

    @Override
    public String description() {
        return STR."在你的回合结束时，失去 \{num} 点力量 。";
    }

    @Override
    public String id() {
        return "StrengthDown";
    }

    @Override
    public PowerType powerType() {
        return PowerType.DEBUFF;
    }

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public boolean isDead() {
        return !alive;
    }
}
