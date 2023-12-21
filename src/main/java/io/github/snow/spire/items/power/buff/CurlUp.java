package io.github.snow.spire.items.power.buff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.core.AttackResult;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.power.BasePower;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/20
 */
public class CurlUp extends BasePower implements EffectProducer {

    private final int block;
    private boolean alive;

    public CurlUp(int block, Fighter host) {
        this.block = block;
        this.alive = true;
        this.host = host;
    }

    @Override
    public void onAfterBeAttacked(AttackResult attackResult, FightContext ctx) {
        if (alive && !attackResult.isDie() && attackResult.getRealDamage() > 0) {
            // 增加格挡effect
            Effect<?> effect = getRoughEffect(host).getFirst()
                    .process(Collections.singletonList(host));
            ctx.addEffectTail(effect);

            // refresh
            this.alive = false;
            host.powerRefresh();
        }
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(host).setProducer(this);
        BlockChanger roughEffect = new BlockChanger(block, source);
        return Collections.singletonList(roughEffect);
    }

    @Override
    public boolean isDead() {
        return !alive;
    }

    @Override
    public String name() {
        return "蜷身";
    }

    @Override
    public String description() {
        return STR."当受到 攻击 伤害时，蜷起身子并获得 \{block} 点格挡 。（每场战斗一次）";
    }

    @Override
    public String id() {
        return "CurlUp";
    }

    @Override
    public PowerType powerType() {
        return PowerType.BUFF;
    }

    @Override
    public boolean isStackable() {
        return false;
    }
}
