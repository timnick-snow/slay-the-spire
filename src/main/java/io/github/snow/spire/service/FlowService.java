package io.github.snow.spire.service;

import io.github.snow.spire.beans.Constants;
import io.github.snow.spire.beans.pojo.StartFlowResult;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.game.Deck;
import io.github.snow.spire.items.CardManager;
import io.github.snow.spire.items.bless.Bless;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.card.UpgradableCard;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author snow
 * @since 2023/12/8
 */
@Service
@RequiredArgsConstructor
public class FlowService extends AbstractShellComponent {
    private final ComponentFlow.Builder componentFlowBuilder;
    private final Terminal terminal;
    private final CardManager cardManager;


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
     * 选卡
     */
    public Optional<Card> chooseCard(List<Card> cards) {
        List<SelectorItem<String>> items = new ArrayList<>();
        for (Card card : cards) {
            String name = "%s：%s E || %s".formatted(card.displayName(), card.costDisplay(), card.description());
            items.add(SelectorItem.of(name, card.displayName()));
        }
        items.add(SelectorItem.of("跳过", Constants.SKIP));
        // 交互选择
        SingleItemSelector<String, SelectorItem<String>> component = new SingleItemSelector<>(getTerminal(),
                items, "选择一张牌...", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        String result = component.run(SingleItemSelector.SingleItemSelectorContext.empty()).getValue().get();
        if (result.equals(Constants.SKIP)) {
            return Optional.empty();
        }
        Card select = cards.stream().filter(card -> card.displayName().equals(result)).findFirst().get();
        return Optional.of(select);
    }

    /**
     * 删卡
     */
    public void removeCard(Deck deck) {
        List<Card> cards = deck.getCards().stream().filter(Card::isRemovable).toList();
        String cardInfo = cardManager.format(cards, true) + "\n";
        writeAndFlush(cardInfo);

        while (true) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withStringInput("cardId").name("从卡组中选择一张牌移除，输入卡id...")
                    .and().build();
            String cardId = flow.run().getContext().get("cardId");
            cardId = cardId.trim();
            if (deck.remove(cardId)) {
                writeAndFlush("一张卡牌被移除(%s)。".formatted(cardId));
                break;
            }
            writeAndFlush("无效的卡id。\n");
        }
    }

    /**
     * 变卡
     */
    public List<Card> transformCard(Deck deck, int n) {
        List<Card> cards = deck.getCards().stream().filter(Card::isRemovable).toList();
        String cardInfo = cardManager.format(cards, true) + "\n";
        writeAndFlush(cardInfo);
        n = Math.min(n, cards.size());
        while (true) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withStringInput("cardIds").name("从卡组中选择%d张牌进行变化，输入卡id，多个id空格分隔...".formatted(n))
                    .and().build();
            String cardIds = flow.run().getContext().get("cardIds");
            cardIds = cardIds.trim();
            String[] ids = cardIds.split(" +");
            if (ids.length == n && Arrays.stream(ids).allMatch(deck::canRemove)) {
                List<Card> res = deck.removeAll(ids);
                writeAndFlush("%d张卡牌被移除：%s。".formatted(n, cardIds));
                return res;
            }
            writeAndFlush("无效的卡id。\n");
        }
    }

    /**
     * 升级卡
     */
    public void upgradeCard(Deck deck) {
        List<Card> list = deck.getCards().stream().filter(card -> {
            if (card instanceof UpgradableCard up) {
                return up.isUpgradable();
            } else {
                return false;
            }
        }).toList();
        writeAndFlush(cardManager.format(list, true) + "\n");

        String cardId;
        while (true) {
            ComponentFlow flow = componentFlowBuilder.clone().reset()
                    .withStringInput("cardId").name("从卡组中选择一张牌升级，输入卡id...")
                    .and().build();
            cardId = flow.run().getContext().get("cardId");
            if (!deck.contains(cardId)) {
                writeAndFlush("无效的卡id。\n");
                continue;
            }

            // 预览升级信息
            String template = "%s：%s，%d E；%s\n";
            String finalCardId = cardId;
            UpgradableCard card = (UpgradableCard) list.stream().filter(c -> c.id().equals(finalCardId)).findFirst().get();
            writeAndFlush(template.formatted("升级前", card.displayName(), card.cost(), card.description()));
            writeAndFlush(template.formatted("升级后", card.upgradeName(), card.upgradeCost(), card.upgradeDescription()));

            flow = componentFlowBuilder.clone().reset()
                    .withConfirmationInput("confirm").name("是否确认升级")
                    .defaultValue(true)
                    .and().build();
            boolean confirm = flow.run().getContext().get("confirm");
            if (!confirm) {
                continue;
            }

            deck.upgrade(cardId);
            writeAndFlush("卡牌升级成功(%s)。".formatted(cardId));
            break;
        }
    }

    public Bless blessSelect(List<Bless> blesses, RunContext runContext) {
        List<SelectorItem<String>> items = new ArrayList<>();
        for (int i = 0; i < blesses.size(); i++) {
            items.add(SelectorItem.of(blesses.get(i).display(runContext), String.valueOf(i + 1)));
        }
        // 交互选择
        SingleItemSelector<String, SelectorItem<String>> component = new SingleItemSelector<>(getTerminal(),
                items, "捏奥的祝福。请选择一项...", null);
        component.setResourceLoader(getResourceLoader());
        component.setTemplateExecutor(getTemplateExecutor());
        String result = component.run(SingleItemSelector.SingleItemSelectorContext.empty()).getValue().get();
        int idx = Convert.toInt(result, 0);
        return blesses.get(idx - 1);
    }

    public void writeAndFlush(String content) {
        terminal.writer().println(content);
        terminal.flush();
    }
}
