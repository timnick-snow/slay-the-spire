package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;

import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/7
 */
public class RedDefend extends RedCard {
    private static final String DESC = "获得5点格挡。";
    private static final String DESC1 = "获得8点格挡。";

    private int block = 5;

    public RedDefend(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.block = 8;
    }

    @Override
    public Card copy(String id) {
        RedDefend copy = (RedDefend) super.copy(id);
        copy.block = this.block;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        BlockChanger adder = new BlockChanger(block, source);
        return Collections.singletonList(adder);
    }

    @Override
    public String baseName() {
        return "防御";
    }

    @Override
    public CardType type() {
        return CardType.SKILL;
    }

    @Override
    public CardRarity rarity() {
        return CardRarity.STARTER;
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
