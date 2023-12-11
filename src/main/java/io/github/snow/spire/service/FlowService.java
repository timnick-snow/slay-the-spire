package io.github.snow.spire.service;

import io.github.snow.spire.beans.pojo.StartFlowResult;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.game.Deck;
import io.github.snow.spire.items.bless.Bless;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Convert;
import io.github.snow.spire.tool.Either;
import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.shell.component.SingleItemSelector;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.component.support.SelectorItem;
import org.springframework.shell.standard.AbstractShellComponent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/8
 */
@Service
@RequiredArgsConstructor
public class FlowService extends AbstractShellComponent {
    private final ComponentFlow.Builder componentFlowBuilder;
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
    public void removeCard(Deck deck) {
        String cardInfo = deck.format(true) + "\n";
        write(cardInfo);

        String cardId;
        while (true) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withStringInput("cardId").name("从卡组中选择一张牌移除，输入卡id...")
                    .and().build();
            cardId = flow.run().getContext().get("cardId");
            if (deck.remove(cardId)) {
                write("一张卡牌被移除(%s)。".formatted(cardId));
                break;
            }
            write("无效的卡id。\n");
        }
    }

    public Bless blessSelect(List<Bless> blesses, RunContext runContext) {
        List<SelectorItem<String>> items = new ArrayList<>();
        for (int i = 0; i < blesses.size(); i++) {
            items.add(SelectorItem.of(blesses.get(i).display(runContext), String.valueOf(i)));
        }
        // 交互选择
        SingleItemSelector<String, SelectorItem<String>> component = new SingleItemSelector<>(getTerminal(),
                items, "捏奥的祝福。请选择一项...", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        String result = component.run(SingleItemSelector.SingleItemSelectorContext.empty()).getValue().get();
        int idx = Convert.toInt(result, 0);
        return blesses.get(idx);
    }

    public void write(String content) {
        terminal.writer().println(content);
        terminal.flush();
    }
}
