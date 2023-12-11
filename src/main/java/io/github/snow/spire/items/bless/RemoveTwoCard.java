package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RemoveTwoCard implements Bless {
    @Override
    public void run(RunContext ctx, RunSupport support) {
        support.removeCard();
        support.removeCard();
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择2张牌移除。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.BETTER_REWARD;
    }
}