package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import lombok.RequiredArgsConstructor;

/**
 * 打击
 *
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
public class RedStrike extends RedCard {

    private final String id;


    @Override
    public CardType type() {
        return CardType.ATTACK;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return "打击";
    }

    @Override
    public String description() {
        return "造成6点伤害。";
    }

    @Override
    public int energy() {
        return 1;
    }
}
