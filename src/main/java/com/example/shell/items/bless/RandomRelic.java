package com.example.shell.items.bless;

import com.example.shell.enums.RelicRarity;
import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class RandomRelic implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo 获得随机遗物
    }

    @Override
    public String display(RunContext ctx) {
        return "获得一个随机%s遗物。".formatted(rarity().getDisplay());
    }

    public abstract RelicRarity rarity();
}
