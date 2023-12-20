package io.github.snow.spire.items.intent;

import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockAdder;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/20
 */
@RequiredArgsConstructor
public class DefendIntent extends BaseIntent {
    private final int block;

    @Override
    public String displayName() {
        return "防守";
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        BlockAdder adder = new BlockAdder(block);
        adder.setSource(new SourceChain().setFighter(fighter).setProducer(this));
        return List.of(adder);
    }

    @Override
    public String description() {
        return "这个敌人打算获取格挡。";
    }

    @Override
    public Intent copy() {
        return new DefendIntent(block);
    }
}
