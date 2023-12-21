package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.UpgradeCardEffect;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
public class CardUpgrade extends BaseRoughEffect<FightCard> {
    public CardUpgrade(EffectTarget effectTarget, SourceChain source) {
        super(effectTarget, source);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Effect<FightCard> process(List<? extends DisplayAble> targets) {
        return new UpgradeCardEffect((List<FightCard>) targets, this);
    }
}
