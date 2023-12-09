package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class TransformTwoCard implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo 变化卡
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择一张牌变化。";
    }
}
