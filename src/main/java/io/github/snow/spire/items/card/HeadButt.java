package io.github.snow.spire.items.card;

import io.github.snow.spire.enums.*;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.MoveDestination;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.effect.rough.CardMove;
import io.github.snow.spire.items.effect.rough.DamageGroup;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class HeadButt extends RedCard {
    private static final String DESC = "造成9点伤害。将弃牌堆中的一张牌放到抽牌堆的顶部。";
    private static final String DESC1 = "造成12点伤害。将弃牌堆中的一张牌放到抽牌堆的顶部。";

    private int damage = 9;

    public HeadButt(String id, int level) {
        super(id, level);
    }

    @Override
    public void upgrade() {
        super.upgrade();
        this.damage = 12;
    }

    @Override
    public Card copy(String id) {
        HeadButt copy = (HeadButt) super.copy(id);
        copy.damage = this.damage;
        return copy;
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        // 伤害
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        DamageGroup damageGroup = new DamageGroup(EffectTarget.SINGLE_OPPONENT, source, damage, 1);
        // 移动卡牌
        MoveDestination dest = new MoveDestination(CardPosition.DRAW_PILE, MoveStrategy.FIRST);
        CardMove cardMove = new CardMove(EffectTarget.DISCARD_PILE_CARD, source.copy(), dest);
        return List.of(damageGroup, cardMove);
    }

    @Override
    public String baseName() {
        return "头槌";
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
