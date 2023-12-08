package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 失去生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossHp implements Bless {

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        int value = getValue(ctx);
        int hp = ctx.getHp();
        ctx.setHp(hp - value);
        return "你的生命值减少了，hp: %d => %d".formatted(hp, ctx.getHp());
    }

    @Override
    public String display(RunContext ctx) {
        int value = getValue(ctx);
        return "受到%d伤害。".formatted(value);
    }

    private static int getValue(RunContext ctx) {
        return switch (ctx.getCharacter()) {
            case IRONCLAD, DEFECT -> 18;
            case SILENT -> 15;
            case WATCHER -> 21;
        };
    }
}
