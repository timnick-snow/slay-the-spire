package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.pojo.PlayRule;
import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.effect.RoughEffect;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/15
 */
@Accessors(fluent = true)
public class FightCard implements Card {
    private final Card card;
    @Getter
    private final DisplayAble host;
    private final String id;

    /**
     * 当前消耗 - 其可能在战斗中变化
     */
    @Setter
    private int cost;
    /**
     * 位置
     */
    @Setter
    @Getter
    private CardPosition position;

    public FightCard(Card card, DisplayAble host, String id) {
        this.card = card;
        this.host = host;
        this.cost = card.cost();
        this.id = id;
        this.position = CardPosition.DRAW_PILE;
    }

    public int originCost() {
        return card.cost();
    }

    public String originCostDisplay() {
        return Card.costDisplay(originCost());
    }

    public boolean isPlayable(PlayRule playRule, FightContext ctx) {
        if (!isPlayable()) {
            System.out.println("这张卡牌 【不能打出】 ！");
            return false;
        }
        if (ctx.getEnergy() < cost()) {
            System.out.println("能量不足！");
            return false;
        }
        return true;
    }

    @Override
    public CardColor color() {
        return card.color();
    }

    @Override
    public CardType type() {
        return card.type();
    }

    @Override
    public CardRarity rarity() {
        return card.rarity();
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String baseName() {
        return card.baseName();
    }

    @Override
    public String displayName() {
        return card.displayName();
    }

    @Override
    public String description() {
        return card.description();
    }

    @Override
    public int cost() {
        return cost;
    }

    @Override
    public Card copy(String id) {
        return new FightCard(card, host, id);
    }

    @Override
    public boolean isPlayable() {
        return card.isPlayable();
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        return card.getRoughEffect(fighter);
    }
}
