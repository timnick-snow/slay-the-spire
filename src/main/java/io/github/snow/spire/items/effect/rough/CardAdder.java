package io.github.snow.spire.items.effect.rough;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.BaseRoughEffect;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.effect.finished.AddCardEffect;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/21
 */
@Getter
public class CardAdder extends BaseRoughEffect<DisplayAble> {
    private final Card card;
    private final CardPosition dest;

    public CardAdder(SourceChain source, Card card, CardPosition dest) {
        super(EffectTarget.NONE, source);
        this.card = card;
        this.dest = dest;
    }

    @Override
    public Effect<DisplayAble> process(List<? extends DisplayAble> targets) {
        return new AddCardEffect(Collections.emptyList(), this);
    }
}
