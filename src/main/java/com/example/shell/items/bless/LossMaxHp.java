package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 失去最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossMaxHp implements Bless {

    @Override
    public void run(RunContext ctx, FlowService flowService) {
        int value = getValue(ctx);
        int maxHp = ctx.getMaxHp();
        ctx.setMaxHp(maxHp - value);
        flowService.write("你的最大生命值减少了：%d -> %d".formatted(maxHp, ctx.getMaxHp()));

        int hp = ctx.getHp();
        if (hp < ctx.getMaxHp()) {
            ctx.setHp(ctx.getMaxHp());
            flowService.write("你的生命值减少了：%d -> %d".formatted(hp, ctx.getHp()));
        }
    }

    @Override
    public String display(RunContext ctx) {
        int value = getValue(ctx);
        return "失去%d最大生命值。".formatted(value);
    }

    private static int getValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
    }
}
