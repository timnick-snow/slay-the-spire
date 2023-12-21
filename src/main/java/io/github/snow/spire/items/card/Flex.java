package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.Strength;
import io.github.snow.spire.items.power.debuff.StrengthDown;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Flex extends RedCard {
    private static final String DESC = "获得2点 【力量】 。你的回合结束时，失去2点 【力量】 。";
    private static final String DESC1 = "获得4点 【力量】 。你的回合结束时，失去4点 【力量】 。";

    private int value = 2;

    public Flex(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.value = 4;
    }

    @Override
    public Card copy(String id) {
        Flex copy = (Flex) super.copy(id);
        copy.value = this.value;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 力量
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        PowerAdder powerAdder = new PowerAdder(EffectTarget.SELF, source.copy(), new Strength(value));
        // 活动肌肉
        PowerAdder down = new PowerAdder(EffectTarget.SELF, source.copy(), new StrengthDown(value));

        return List.of(powerAdder, down);
    }

    @Override
    public String baseName() {
        return "活动肌肉";
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
        return 0;
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
