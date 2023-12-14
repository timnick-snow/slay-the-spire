package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.fight.AttackResult;
import io.github.snow.spire.beans.fight.DamageGroup;
import io.github.snow.spire.beans.fight.EffectResult;
import io.github.snow.spire.enums.EnemyType;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightLifecycle;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.intent.Intent;

import java.util.List;

/**
 * 敌人
 *
 * @author snow
 * @since 2023/12/14
 */
public interface Enemy extends DisplayAble, FightLifecycle {

    /**
     * 敌人类型
     */
    EnemyType enemyType();

    /**
     * id - 用于玩家指示
     */
    String id();

    /**
     * id - 敌人名称
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
     * copy instance
     */
    Enemy copy(String id, int a, int b);

    /**
     * 意图
     *
     * @param ctx 战斗上下文
     */
    Intent intent(FightContext ctx);

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
    EffectResult addEffect(Effect effect, FightContext ctx);
}
