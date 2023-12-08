package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ChooseUncommonColorlessCard implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        // todo 卡牌
        return null;
    }

    @Override
    public String display(RunContext ctx) {
        return "选择一张牌加入到你的牌组中。";
    }
}
