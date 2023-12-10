package io.github.snow.spire.items.bless;

import io.github.snow.spire.items.relic.NeowsBlessing;
import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetNeowsBlessing implements Bless {

    @Override
    public void run(RunContext ctx, FlowService flowService) {
        ctx.getRelicGroup().addRelic(new NeowsBlessing());
        flowService.write("你获得了【涅奥的悲恸】！");
    }

    @Override
    public String display(RunContext ctx) {
        return "获得遗物【涅奥的悲恸】";
    }
}
