package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.rough.BlockAdder;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.BaseEffect;
import lombok.Getter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/18
 */
@Getter
public class BlockEffect extends BaseEffect<Fighter> {
    private final BlockAdder adder;

    public BlockEffect(List<Fighter> targets, BlockAdder adder) {
        super(targets);
        this.adder = adder;
        adder.getSource().setEffect(this);
    }

    @Override
    public void work(FightContext ctx) {
        getTargets().forEach(fighter -> fighter.addBlock(adder));
    }
}
