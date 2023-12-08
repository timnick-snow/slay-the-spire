package com.example.shell.items.bless;

import com.example.shell.service.FlowService;
import com.example.shell.temp.RunContext;
import org.jline.terminal.Terminal;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RemoveTwoCard implements Bless {
    @Override
    public String effect(RunContext ctx, FlowService flowService) {
        String cardId = flowService.removeCard();
        String formatStr = "1张卡牌被移除(%s)。";
        String hint = formatStr.formatted(cardId);
        Terminal terminal = flowService.getTerminal();
        terminal.writer().println(hint);
        terminal.flush();

        cardId = flowService.removeCard();
        return formatStr.formatted(cardId);
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择2张牌移除。";
    }
}
