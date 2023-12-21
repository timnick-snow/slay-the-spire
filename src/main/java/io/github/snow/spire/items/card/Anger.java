package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.CardAdder;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Anger extends RedCard {
    private static final String DESC = "造成6点伤害。在弃牌堆放入一张此牌的复制品。";
    private static final String DESC1 = "造成8点伤害。在弃牌堆放入一张此牌的复制品。";

    private int damage = 6;

    public Anger(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 8;
    }

    @Override
    public Card copy(String id) {
        Anger copy = (Anger) super.copy(id);
        copy.damage = this.damage;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        // 增加卡牌
        CardAdder cardAdder = new CardAdder(source.copy(), this.copy("tmp"), CardPosition.DISCARD_PILE);
        return List.of(damageGroup, cardAdder);
    }

    @Override
    public String baseName() {
        return "愤怒";
    }

    @Override
    public CardType type() {
        return CardType.ATTACK;
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
