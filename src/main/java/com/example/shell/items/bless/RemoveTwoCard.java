package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RemoveTwoCard implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        flowService.removeCard();
        flowService.removeCard();
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择2张牌移除。";
    }
}
