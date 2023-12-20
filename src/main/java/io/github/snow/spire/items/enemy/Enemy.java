package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EnemyType;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.intent.Intent;

/**
 * 敌人
 *
 * @author snow
 * @since 2023/12/14
 */
public interface Enemy extends Fighter {

    /**
     * 敌人类型
     */
    EnemyType enemyType();

    /**
     * copy instance
     */
    Enemy copy(String number);

    /**
     * 意图
     *
     * @param ctx 战斗上下文
     */
    Intent intent(FightContext ctx);

    void setHp(int hp);
}
