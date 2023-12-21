package io.github.snow.spire.items.effect.finished;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.effect.BaseEffect;
import io.github.snow.spire.items.effect.rough.CardUpgrade;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class UpgradeCardEffect extends BaseEffect<FightCard, CardUpgrade> {
    public UpgradeCardEffect(List<FightCard> targets, CardUpgrade roughEffect) {
        super(targets, roughEffect);
    }

    @Override
    public void work(FightContext ctx) {
        super.work(ctx);

        List<FightCard> targets = getTargets();
        ctx.upgradeCards(targets);
    }
}
