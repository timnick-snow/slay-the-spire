package io.github.snow.spire.items.core;


import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.Heal;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.Power;

import java.util.List;

/**
 * 战斗者
 *
 * @author snow
 * @since 2023/12/15
 */
public interface Fighter extends DisplayAble, FightLifecycle {
    /**
     * 编号 - 用于玩家指示
     */
    String number();

    /**
     * 名称
     */
    String name();

    /**
     * max hp
     */
    int maxHp();

    /**
     * hp
     */
    int hp();

    /**
     * 格挡
     */
    int block();

    /**
     * 能力
     */
    List<Power> powers();

    /**
     * 回合开始时失去格挡的值
     */
    int blockLossOnRoundStart();

    /**
     * 受到伤害
     */
    AttackResult beAttacked(DamageGroup damageGroup, FightContext ctx);

    /**
     * 施加能力
     */
    PowerResult addPower(PowerAdder powerAdder, FightContext ctx);

    /**
     * 增加/失去格挡
     */
    void changeBlock(BlockChanger blockChanger, FightContext ctx);

    /**
     * 治疗
     */
    void heal(Heal heal, FightContext ctx);

    /**
     * 是否死亡
     */
    boolean isDie();

    /**
     * 能力刷新
     */
    void powerRefresh();
}
