package com.example.shell.items.bless;

import com.example.shell.items.relic.NeowsBlessing;
import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetNeowsBlessing implements Bless {

    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        ctx.getRelicGroup().addRelic(new NeowsBlessing());
        return "你获得了【涅奥的悲恸】！";
    }

    @Override
    public String display(RunContext ctx) {
        return "获得遗物【涅奥的悲恸】";
    }
}
