package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.PowerAdder;

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
     * 战斗开始后
     */
    default void onAfterFightStart(FightContext ctx) {
    }

    /**
     * 战斗结束
     */
    default void onFightEnd(FightContext ctx) {
    }

    /**
     * 玩家回合开始
     */
    default void onPlayerRoundStart(FightContext ctx) {
    }

    /**
     * 玩家回合结束
     */
    default void onPlayerRoundEnd(FightContext ctx) {
    }

    /**
     * 敌方回合开始
     */
    default void onEnemyRoundStart(FightContext ctx) {
    }

    /**
     * 敌方回合结束
     */
    default void onEnemyRoundEnd(FightContext ctx) {
    }

    default void simulateAttack(DamageGroup damageGroup, FightContext ctx) {
    }

    /**
     * 发起进攻
     */
    default void onAttack(DamageGroup damageGroup, FightContext ctx) {
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

    /**
     * 被攻击后
     */
    default void onAfterBeAttacked(AttackResult attackResult, FightContext ctx) {
    }

    default void onBeforeAddPower(PowerAdder powerAdder, FightContext ctx) {
    }

    /**
     * 护甲回合开始时自动失去
     */
    default void onBlockAutoLose(BlockChanger blockChanger, FightContext ctx) {
    }
}
