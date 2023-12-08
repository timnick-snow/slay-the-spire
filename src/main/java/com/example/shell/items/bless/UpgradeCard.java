package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class UpgradeCard implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        // todo 升级卡
        return null;
    }

    @Override
    public String displayName(RunContext ctx) {
        return "从你的牌组内选择一张牌升级。";
    }
}
