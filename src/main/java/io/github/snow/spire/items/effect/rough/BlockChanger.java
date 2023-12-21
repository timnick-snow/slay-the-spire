package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.BlockType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
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
public class BlockChanger extends BaseRoughEffect<Fighter> {
    private int block;
    private final BlockType blockType;

    public BlockChanger(int block, SourceChain source) {
        this(EffectTarget.SELF, source, block, BlockType.DIRECTLY);
    }

    public BlockChanger(EffectTarget effectTarget, SourceChain source, int block, BlockType blockType) {
        super(effectTarget, source);
        this.block = block;
        this.blockType = blockType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public BlockEffect process(List<? extends DisplayAble> targets) {
        return new BlockEffect((List<Fighter>) targets, this);
    }
}
