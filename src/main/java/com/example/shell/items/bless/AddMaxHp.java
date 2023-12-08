package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 增加最大生命
 *
 * @author snow
 * @since 2023/12/8
 */
public class AddMaxHp implements Bless {

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        int value = switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
        ctx.setMaxHp(ctx.getMaxHp() + value);
        ctx.setHp(ctx.getHp() + value);
        return "你的最大生命值增加了！";
    }

    @Override
    public String displayName(RunContext ctx) {
        int value = switch (ctx.getCharacter()) {
            case IRONCLAD -> 8;
            case SILENT -> 6;
            case DEFECT, WATCHER -> 7;
        };
        return "最大生命值+%d。".formatted(value);
    }
}
