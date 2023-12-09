package com.example.shell.items.bless;

import com.example.shell.items.card.Card;
import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;

import java.util.function.Predicate;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class ChooseCard implements Bless {
    @Override
    public void run(RunContext ctx, FlowService flowService) {
        // todo 选择卡
    }

    @Override
    public String display(RunContext ctx) {
        return "选择一张%s卡牌加入到你的牌组中。".formatted(trait());
    }

    public abstract String trait();

    public abstract Predicate<Card> filter(RunContext ctx);
}
