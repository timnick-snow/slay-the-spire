package io.github.snow.spire.items.bless;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class ChooseCard implements Bless {
    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        return support.rewardChooseCard(filter(ctx));
    }

    @Override
    public String display(RunContext ctx) {
        return "选择一张%s卡牌加入到你的牌组中。".formatted(trait());
    }

    public abstract String trait();

    public abstract Predicate<Card> filter(RunContext ctx);
}
