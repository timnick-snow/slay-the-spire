package io.github.snow.spire.items.intent;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.EffectProducer;
import io.github.snow.spire.items.enemy.Enemy;

/**
 * @author snow
 * @since 2023/12/19
 */
public interface Intent extends DisplayAble, EffectProducer {

    /**
     * 详细描述
     *
     * @return 意图的详细描述
     */
    String description();

    Intent simulate(Enemy enemy, FightContext ctx);

    Intent copy();

}
