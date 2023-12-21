package io.github.snow.spire.items.effect;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.enums.MoveStrategy;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.MoveDestination;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.finished.MoveCardEffect;
import io.github.snow.spire.items.effect.rough.CardMove;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class Effects {

    public static CardMove cardExhaust(FightCard card, FightContext ctx) {
        SourceChain source = new SourceChain().setFighter(ctx.getPlayer()).setProducer(card);
        return new CardMove(EffectTarget.NONE, source, new MoveDestination(CardPosition.EXHAUST_PILE, MoveStrategy.LAST));
    }

    public static MoveCardEffect cardExhaustEffect(FightCard card, FightContext ctx) {
        CardMove cardMove = cardExhaust(card, ctx);
        return cardMove.process(List.of(card));
    }
}
