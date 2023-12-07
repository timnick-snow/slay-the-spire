package com.example.shell.game;

import com.example.shell.items.card.Card;

import java.util.ArrayList;
import java.util.List;

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
-------------------------------------------------------
id   |   名称   | 颜色 | 类型 | 耗能 | 描述
-------------------------------------------------------
c101 |   打击   | 红色 | 攻击 |  1  |  造成6点伤害
 */
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
}
