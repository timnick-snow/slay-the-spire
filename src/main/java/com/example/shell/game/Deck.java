package com.example.shell.game;

import com.example.shell.items.card.Card;
import com.example.shell.items.card.PlayCard;

import java.util.ArrayList;
import java.util.List;

import static com.example.shell.tool.FormatUtil.center;

/**
 * @author snow
 * @since 2023/12/7
 */
public class Deck {
    private final List<Card> cards = new ArrayList<>();

    public String formatCount() {
        return "卡组: %d".formatted(cards.size());
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void addAll(List<Card> list) {
        this.cards.addAll(list);
    }

    public String format(boolean verbose) {
        String res = formatCount() + "\n";
        StringBuilder buf = new StringBuilder();
        if (verbose) {
/*
--------------------------------------------------------------------------------------------------
|  id  |   名称   | 颜色 | 类型 | 耗能 | 稀有度 | 描述
--------------------------------------------------------------------------------------------------
| c101 |   打击   | 红色 | 攻击 |  1  |  初始  | 造成6点伤害。造成6点伤害。造成6点伤害。造成6点伤害。造成6点...
 */
            String divide = "--------------------------------------------------------------------------------------------------\n";
            buf.append(divide)
                    .append("|  id  |   名称   | 颜色 | 类型 | 耗能 | 稀有度 | 描述\n")
                    .append(divide);
            for (Card card : cards) {
                buf.append("|").append(center(card.id(), 6));
                buf.append("|").append(center(card.name(), 8));
                buf.append("|").append(center(card.color().getDisplay(), 4));
                buf.append("|").append(center(card.type().getDisplay(), 4));
                // 耗能
                if (card instanceof PlayCard playCard) {
                    buf.append("|").append(center(String.valueOf(playCard.energy()), 6));
                } else {
                    buf.append("|").append(center("N", 5));
                }
                buf.append("|").append(center(card.rarity().getDisplay(), 6));
                // 描述
                buf.append("| ");
                if (card.description().length() <= 32) {
                    buf.append(card.description());
                } else {
                    buf.append(card.description(), 0, 32).append("...");
                }
                buf.append("\n");
            }
        } else {
            // 简要的
            for (int i = 0; i < cards.size(); i++) {
                buf.append(cards.get(i).name());
                if (i == cards.size() - 1) {
                    break;
                }
                if (i % 5 == 4) {
                    buf.append("\n");
                } else {
                    buf.append("\t\t\t");
                }
            }
        }
        buf.append("\n");
        res += buf;
        return res;
    }

    public boolean contains(String cardId) {
        return cards.stream().anyMatch(c -> c.id().equals(cardId));
    }

    public boolean remove(String cardId) {
        int idx = -1;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).id().equals(cardId)) {
                idx = i;
                break;
            }
        }
        if (idx >= 0) {
            cards.remove(idx);
            return true;
        }
        return false;
    }
}
