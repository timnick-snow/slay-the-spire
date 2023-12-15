package io.github.snow.spire.items.core;


import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.Effect;

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
     * 能力
     */
    List<Effect> powers();

    /**
     * 受到伤害
     */
    AttackResult beAttacked(DamageGroup damageGroup, FightContext ctx);

    /**
     * 施加能力
     */
    EffectResult addEffect(EffectAdder effectAdder, FightContext ctx);
}
