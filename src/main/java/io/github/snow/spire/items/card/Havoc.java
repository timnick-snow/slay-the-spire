package io.github.snow.spire.items.card;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CardRarity;
import io.github.snow.spire.enums.CardType;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.core.SourceChain;
import io.github.snow.spire.items.effect.*;
import io.github.snow.spire.items.effect.finished.MoveCardEffect;
import io.github.snow.spire.tool.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/12
 */
public class Havoc extends RedCard {
    private static final String DESC = "打出抽牌堆顶部的牌，将其 【消耗】 。";
    private static final String DESC1 = "打出抽牌堆顶部的牌，将其 【消耗】 。";

    public Havoc(String id, int level) {
        super(id, level);
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        SourceChain source = new SourceChain().setFighter(fighter).setProducer(this);
        return List.of(new HavocRoughEffect(source));
    }

    static class HavocRoughEffect extends BaseRoughEffect<DisplayAble> {

        public HavocRoughEffect(SourceChain source) {
            super(EffectTarget.NONE, source);
        }

        @Override
        public Effect<DisplayAble> process(List<? extends DisplayAble> targets) {
            return new HavocEffect(Collections.emptyList(), this);
        }
    }

    static class HavocEffect extends BaseEffect<DisplayAble, HavocRoughEffect> {

        public HavocEffect(List<DisplayAble> targets, HavocRoughEffect roughEffect) {
            super(targets, roughEffect);
        }

        @Override
        public void work(FightContext ctx) {
            super.work(ctx);
            // 打出抽牌堆顶部的牌，将其 【消耗】
            List<FightCard> cards = ctx.draw(1);
            if (cards.isEmpty()) {
                return;
            }
            FightCard card = cards.getFirst();
            ctx.moveCardToLast(card, CardPosition.PLAY_ZONE);

            // 获得抽取卡牌的效果
            List<RoughEffect<?>> effectList = card.getRoughEffect(ctx.getPlayer());
            List<Effect<?>> effects = new ArrayList<>();
            for (RoughEffect<?> roughEffect : effectList) {
                EffectTarget effectTarget = roughEffect.effectTarget();
                List<DisplayAble> targets = new ArrayList<>();
                switch (effectTarget) {
                    case NONE -> {
                    }
                    case SELF -> targets.add(ctx.getPlayer());
                    case ALL_OPPONENT -> targets.addAll(ctx.getEnemies());
                    case SINGLE_OPPONENT, RANDOM_OPPONENT -> {
                        int idx = ctx.getOtherRandom().nextInt(0, ctx.getEnemies().size());
                        targets.add(ctx.getEnemies().get(idx));
                    }
                    default -> Output.println("目标参数待完善，卡牌部分功能可能无法生效！");

                }
                effects.add(roughEffect.process(targets));
            }
            // card 消耗
            MoveCardEffect exhaust = Effects.cardExhaustEffect(card, ctx);
            effects.add(exhaust);
            // add to effect run container
            ctx.addEffectTail(effects);
        }
    }

    @Override
    public String baseName() {
        return "破灭";
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
        return level == 0 ? 1 : 0;
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
