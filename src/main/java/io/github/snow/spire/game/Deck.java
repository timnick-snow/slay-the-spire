package io.github.snow.spire.game;

import io.github.snow.spire.items.card.BaseCard;
import io.github.snow.spire.items.card.Card;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public boolean canRemove(String cardId) {
        Optional<Card> first = cards.stream().filter(card -> card.isRemovable() && card.id().equals(cardId)).findFirst();
        return first.isPresent();
    }

    public boolean remove(String cardId) {
        Optional<Card> first = cards.stream().filter(card -> card.isRemovable() && card.id().equals(cardId)).findFirst();
        if (first.isPresent()) {
            cards.remove(first.get());
            return true;
        } else {
            return false;
        }
    }

    public void upgrade(String cardId) {
        BaseCard card = (BaseCard) cards.stream().filter(c -> c.id().equals(cardId)).findFirst().get();
        card.upgrade();
    }

    public List<Card> removeAll(String[] ids) {
        List<Card> res = new ArrayList<>();
        for (String id : ids) {
            Optional<Card> first = cards.stream().filter(card -> card.isRemovable() && card.id().equals(id)).findFirst();
            if (first.isPresent()) {
                Card card = first.get();
                cards.remove(card);
                res.add(card);
            }
        }
        return res;
    }
}
