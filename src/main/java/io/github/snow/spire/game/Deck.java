package io.github.snow.spire.game;

import io.github.snow.spire.items.card.BaseCard;
import io.github.snow.spire.items.card.Card;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static io.github.snow.spire.tool.FormatUtil.center;


/**
 * @author snow
 * @since 2023/12/7
 */
@Getter
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

    public void upgrade(String cardId) {
        BaseCard card = (BaseCard) cards.stream().filter(c -> c.id().equals(cardId)).findFirst().get();
        card.setLevel(card.getLevel() + 1);
    }
}
