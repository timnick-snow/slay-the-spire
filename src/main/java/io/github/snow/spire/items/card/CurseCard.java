package io.github.snow.spire.items.card;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardColor;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.RoughEffect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
@Slf4j
public abstract class CurseCard implements Card {
    protected final String id;

    public CurseCard(String id) {
        this.id = id;
    }

    @Override
    public CardColor color() {
        return CardColor.CURSE;
    }

    @Override
    public CardType type() {
        return CardType.CURSE;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.CURSE;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public int cost() {
        return -2;
    }

    @Override
    public boolean isPlayable(FightContext ctx) {
        return false;
    }

    @Override
    public Card copy(String id) {
        try {
            Constructor<? extends CurseCard> constructor = this.getClass().getDeclaredConstructor(String.class);
            return constructor.newInstance(id);
        } catch (Exception e) {
            log.error("card copy error", e);
            return null;
        }
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        return Collections.emptyList();
    }
}
