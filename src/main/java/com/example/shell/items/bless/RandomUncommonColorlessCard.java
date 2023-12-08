package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomUncommonColorlessCard implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        // todo 卡牌
        return null;
    }

    @Override
    public String display(RunContext ctx) {
        return "获得一张罕见的随机无色卡。";
    }
}
