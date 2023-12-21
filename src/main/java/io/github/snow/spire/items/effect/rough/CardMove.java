package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.MoveDestination;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.MoveCardEffect;
import lombok.Getter;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
@Getter
public class CardMove extends BaseRoughEffect<FightCard> {

    private final MoveDestination dest;

    public CardMove(EffectTarget effectTarget, SourceChain source, MoveDestination dest) {
        super(effectTarget, source);
        this.dest = dest;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Effect<FightCard> process(List<? extends DisplayAble> targets) {
        return new MoveCardEffect((List<FightCard>) targets, this);
    }
}
