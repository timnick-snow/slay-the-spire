package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;

/**
 * 战斗生命周期
 *
 * @author snow
 * @since 2023/12/15
 */
public interface FightLifecycle {
    /**
     * 战斗开始
     */
    default void onFightStart(FightContext ctx) {
    }

    /**
     * 回合开始
     */
    default void onRoundStart(FightContext ctx) {
    }

    /**
     * 回合结束
     */
    default void onRoundEnd(FightContext ctx) {
    }

    /**
     * 被攻击
     */
    default void onBeAttacked(DamageGroup damageGroup, FightContext ctx) {
    }

    /**
     * 受到伤害
     */
    default void onGetDamage(ValueWrapper damage, FightContext ctx) {
    }

    /**
     * 受到真实伤害
     */
    default void onGetInjured(ValueWrapper real, FightContext ctx) {
    }

    default void onBeforeAddEffect(EffectAdder effectAdder, FightContext ctx) {
    }
}
