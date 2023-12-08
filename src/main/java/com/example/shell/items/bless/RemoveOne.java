package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RemoveOne implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        String cardId = flowService.removeCard();
        return "一张卡牌被移除(%s)。".formatted(cardId);
    }

    @Override
    public String displayName(RunContext ctx) {
        return "从你的牌组内选择一张牌移除。";
    }
}
