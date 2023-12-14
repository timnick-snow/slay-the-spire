package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.fight.DamageGroup;
import io.github.snow.spire.beans.fight.ValueWrapper;

public interface FightLifecycle {
    /**
     * 回合结束
     */
    default void onTurnEnd(FightContext ctx) {
    }

    /**
     * 回合开始
     */
    default void onTurnStart(FightContext ctx) {
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
}
