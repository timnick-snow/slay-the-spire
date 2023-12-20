package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.finished.BlockEffect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
@Getter
@Setter
public class BlockAdder extends BaseRoughEffect<Fighter> {
    private int block;

    public BlockAdder(int block) {
        super(EffectTarget.SELF);
        this.block = block;
    }

    public BlockAdder(EffectTarget effectTarget) {
        super(effectTarget);
    }

    @Override
    @SuppressWarnings("unchecked")
    public BlockEffect process(List<? extends DisplayAble> targets) {
        BlockEffect effect = new BlockEffect((List<Fighter>) targets, this);
        source.setEffect(effect);
        return effect;
    }
}
