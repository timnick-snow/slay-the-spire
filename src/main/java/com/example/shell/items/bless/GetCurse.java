package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetCurse implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        // todo 诅咒卡
        return null;
    }

    @Override
    public String display(RunContext ctx) {
        return "得一张随机诅咒牌。";
    }
}
