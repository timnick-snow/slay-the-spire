package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.finished.DamageEffect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/14
 */
@Getter
@Setter
public class DamageGroup extends BaseRoughEffect<Fighter> {
    /**
     * 基本值
     */
    private int base;
    /**
     * 段数
     */
    private int num;

    public DamageGroup(EffectTarget effectTarget, SourceChain source, int base, int num) {
        super(effectTarget, source);
        this.base = base;
        this.num = num;
    }

    @Override
    @SuppressWarnings("unchecked")
    public DamageEffect process(List<? extends DisplayAble> targets) {
        return new DamageEffect((List<Fighter>) targets, this);
    }
}
