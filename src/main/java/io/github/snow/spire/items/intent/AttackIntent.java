package io.github.snow.spire.items.intent;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/19
 */
@RequiredArgsConstructor
public class AttackIntent implements Intent {
    private final int base;
    private final int num;

    @Override
    public String displayName() {
        return "攻击(%d%s)".formatted(
                base,
                num == 1 ? "" : "×" + num
        );
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, base, num);
        damageGroup.setSource(new SourceChain().setProducer(this).setFighter(fighter));
        return Collections.singletonList(damageGroup);
    }

    @Override
    public String description() {
        String desc = "这个敌人打算发动攻击，造成 %d 点伤害".formatted(base);
        if (num == 1) {
            desc += "。";
        } else {
            desc += "，连续攻击 %d 次。".formatted(num);
        }
        return desc;
    }
}
