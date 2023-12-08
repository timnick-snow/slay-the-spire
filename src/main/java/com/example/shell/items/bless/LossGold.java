package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * 失去金币
 *
 * @author snow
 * @since 2023/12/8
 */
public class LossGold implements Bless {

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        ctx.setGold(0);
        return "你的金币清零了";
    }

    @Override
    public String displayName(RunContext ctx) {
        return "失去所有的金币。";
    }
}
