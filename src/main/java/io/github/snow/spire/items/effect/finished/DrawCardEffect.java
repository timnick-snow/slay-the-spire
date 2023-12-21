package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.CardDraw;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class DrawCardEffect extends BaseEffect<DisplayAble, CardDraw> {
    public DrawCardEffect(List<DisplayAble> targets, CardDraw roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);
        ctx.draw(roughEffect.getValue());
    }
}
