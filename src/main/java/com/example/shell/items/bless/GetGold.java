package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public abstract class GetGold implements Bless {

    protected abstract int getGoldAdd();

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        int gold = ctx.getGold();
        ctx.setGold(gold + getGoldAdd());
        return "你的金币增加了：%d -> %d".formatted(gold, ctx.getGold());
    }

    @Override
    public String display(RunContext ctx) {
        return "获得%d金币。".formatted(getGoldAdd());
    }
}
