package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.CardAdder;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class AddCardEffect extends BaseEffect<DisplayAble, CardAdder> {
    public AddCardEffect(List<DisplayAble> targets, CardAdder roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);
        Card card = roughEffect.getCard();
        CardPosition dest = roughEffect.getDest();
        FightCard fightCard = new FightCard(card, ctx.getPlayer(), ctx.nextCid());
        ctx.addFightCard(fightCard, dest);
    }
}
