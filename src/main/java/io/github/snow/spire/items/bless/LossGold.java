package io.github.snow.spire.items.bless;

import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.RunContext;

/**
 * 失去金币
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossGold implements Bless {

    @Override
    public void run(RunContext ctx, FlowService flowService) {
        ctx.setGold(0);
        flowService.write("你的金币清零了");
    }

    @Override
    public String display(RunContext ctx) {
        return "失去所有的金币。";
    }
}
