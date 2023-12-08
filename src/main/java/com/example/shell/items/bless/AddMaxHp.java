package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public abstract class AddMaxHp implements Bless {

    protected abstract int getAddValue(RunContext ctx);

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        int value = getAddValue(ctx);
        ctx.setMaxHp(ctx.getMaxHp() + value);
        ctx.setHp(ctx.getHp() + value);
        return "你的最大生命值增加了！";
    }

    @Override
    public String display(RunContext ctx) {
        int value = getAddValue(ctx);
        return "最大生命值+%d。".formatted(value);
    }
}
