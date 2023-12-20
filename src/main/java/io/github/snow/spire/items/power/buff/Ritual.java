package io.github.snow.spire.items.power.buff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.finished.PowerEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.Player;
import io.github.snow.spire.items.power.BasePower;
import io.github.snow.spire.items.power.Strength;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/19
 */
public class Ritual extends BasePower implements EffectProducer {

    public Ritual(int num) {
        super(num);
    }

    @Override
    public void onPlayerRoundEnd(FightContext ctx) {
        if (host instanceof Player) {
            work(ctx);
        }
    }

    @Override
    public void onEnemyRoundEnd(FightContext ctx) {
        if (host instanceof Enemy) {
            work(ctx);
        }
    }

    private void work(FightContext ctx) {
        trigger();

        // 增加力量
        Effect<?> effect = getRoughEffect(host).getFirst()
                .process(Collections.singletonList(host));
        ctx.addEffectHead(effect);
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(host).setProducer(this);
        PowerAdder roughEffect = new PowerAdder(EffectTarget.SELF, new Strength(amount()));
        roughEffect.setSource(source);
        return Collections.singletonList(roughEffect);
    }

    @Override
    public String name() {
        return "仪式";
    }

    @Override
    public String description() {
        return STR."在回合结束时，获得 \{num} 点力量。";
    }

    @Override
    public String id() {
        return "Ritual";
    }

    @Override
    public PowerType powerType() {
        return PowerType.BUFF;
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
