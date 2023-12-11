package io.github.snow.spire.items.bless;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class RandomCard implements Bless {
    @Override
    public void run(RunContext ctx, RunSupport support) {
        // todo 获得随机卡
    }

    @Override
    public String display(RunContext ctx) {
        return "获得一张随机%s卡牌。".formatted(trait());
    }

    public abstract String trait();

    public abstract Predicate<Card> filter(RunContext ctx);
}
