package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.CardMove;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class MoveCardEffect extends BaseEffect<FightCard, CardMove> {
    public MoveCardEffect(List<FightCard> targets, CardMove roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);

        getTargets().forEach(card -> ctx.moveCard(card, roughEffect.getDest()));
    }
}
