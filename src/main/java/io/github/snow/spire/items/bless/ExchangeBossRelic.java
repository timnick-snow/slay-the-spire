package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ExchangeBossRelic implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo boss 遗物
    }

    @Override
    public String display(RunContext ctx) {
        return "失去初始遗物，获得一件随机的Boss遗物。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.SPECIAL;
    }
}
