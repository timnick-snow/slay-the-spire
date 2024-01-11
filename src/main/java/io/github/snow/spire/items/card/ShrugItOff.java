package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.CardAdder;
import io.github.snow.spire.items.effect.rough.CardDraw;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class ShrugItOff extends RedCard {
    private static final String DESC = "获得8点 【格挡】 。抽1张牌。";
    private static final String DESC1 = "获得11点 【格挡】 。抽1张牌。";

    private int block = 8;
    private final int draw = 1;

    public ShrugItOff(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.block = 11;
    }

    @Override
    public Card copy(String id) {
        ShrugItOff copy = (ShrugItOff) super.copy(id);
        copy.block = 11;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // block
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        BlockChanger blockAdd = new BlockChanger(block, source);
        // draw
        CardDraw cardDraw = new CardDraw(source.copy(), draw);
        return List.of(blockAdd, cardDraw);
    }

    @Override
    public String baseName() {
        return "耸肩无视";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.COMMON;
    }

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String description() {
        return level == 0 ? DESC : DESC1;
    }

    @Override
    public String upgradeDescription() {
        return DESC1;
    }
}
