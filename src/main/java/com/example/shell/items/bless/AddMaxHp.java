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
    public void run(RunContext ctx, FlowService flowService) {
        int addValue = getAddValue(ctx);
        int maxHp = ctx.getMaxHp();
        int hp = ctx.getHp();
        ctx.setMaxHp(maxHp + addValue);
        ctx.setHp(hp + addValue);
        String content = "你的最大生命值增加了：%d -> %d\n你的生命值增加了：%d -> %d".formatted(maxHp, ctx.getMaxHp(), hp, ctx.getHp());
        flowService.write(content);
    }

    @Override
    public String display(RunContext ctx) {
        int value = getAddValue(ctx);
        return "最大生命值+%d。".formatted(value);
    }
}
