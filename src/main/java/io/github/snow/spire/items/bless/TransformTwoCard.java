package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class TransformTwoCard implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo 变化卡
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择两张牌变化。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.BETTER_REWARD;
    }
}
