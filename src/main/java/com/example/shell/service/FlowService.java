package com.example.shell.service;

import com.example.shell.beans.StartFlowResult;
import com.example.shell.enums.Characters;
import com.example.shell.game.Deck;
import com.example.shell.game.RunSupport;
import com.example.shell.items.bless.Bless;
import com.example.shell.tool.Convert;
import com.example.shell.tool.Either;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snow
 * @since 2023/12/8
 */
@Service
@RequiredArgsConstructor
public class FlowService {
    private final ComponentFlow.Builder componentFlowBuilder;
    private final RunSupport runSupport;
    @Getter
    private final Terminal terminal;

    public Either<String, StartFlowResult> startSelect() {
        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("character")
                .name("职业")
                .selectItem("战士", "IRONCLAD")
                .and()
                .withStringInput("level")
                .name("难度(0-20)")
                .defaultValue("0")
                .and()
                .build();
        ComponentFlow.ComponentFlowResult result = flow.run();
        String role = result.getContext().get("character");
        int level = Convert.toInt(result.getContext().get("level"), -1);
        if (level < 0 || level > 20) {
            return Either.left("难度(0-20)，输入错误");
        }
        return Either.right(new StartFlowResult(Characters.valueOf(role), level));
    }

    /**
     * 删卡
     */
    public String removeCard() {
        Deck deck = runSupport.getRunContext().getDeck();
        String cardInfo = deck.format(true) + "\n";
        terminal.writer().println(cardInfo);
        terminal.flush();

        String cardId;
        while (true) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withStringInput("cardId").name("从卡组中选择一张牌移除，输入卡id...")
                    .and().build();
            cardId = flow.run().getContext().get("cardId");
            if (deck.remove(cardId)) {
                break;
            }
            terminal.writer().println("无效的卡id。\n");
            terminal.flush();
        }
        return cardId;
    }

    public void blessSelect(List<Bless> blesses) {
        Map<String, String> items = new HashMap<>();
        for (int i = 0; i < blesses.size(); i++) {
            items.put(blesses.get(i).display(runSupport.getRunContext()), String.valueOf(i));
        }
        ComponentFlow flow = componentFlowBuilder.clone().reset()
                .withSingleItemSelector("id").name("捏奥的祝福。请选择一项...")
                .selectItems(items)
                .and().build();
        var result = flow.run();
        int idx = Convert.toInt(result.getContext().get("id"), 0);
        String effect = blesses.get(idx).effect(runSupport.getRunContext(), this);
        terminal.writer().println(effect);
        terminal.flush();
    }
}
