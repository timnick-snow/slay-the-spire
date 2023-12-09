package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ExchangeBossRelic implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo boss 遗物
    }

    @Override
    public String display(RunContext ctx) {
        return "失去初始遗物，获得一件随机的Boss遗物。";
    }
}
