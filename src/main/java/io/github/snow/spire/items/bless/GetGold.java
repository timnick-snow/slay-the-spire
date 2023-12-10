package io.github.snow.spire.items.bless;

import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public abstract class GetGold implements Bless {

    protected abstract int getGoldAdd();

    @Override
    public void run(RunContext ctx, FlowService flowService) {
        int gold = ctx.getGold();
        ctx.setGold(gold + getGoldAdd());
        flowService.write("你的金币增加了：%d -> %d".formatted(gold, ctx.getGold()));
    }

    @Override
    public String display(RunContext ctx) {
        return "获得%d金币。".formatted(getGoldAdd());
    }
}
