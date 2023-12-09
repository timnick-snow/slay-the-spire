package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetPotion implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo 药水
    }

    @Override
    public String display(RunContext ctx) {
        return "获得3个随机药水。";
    }
}
