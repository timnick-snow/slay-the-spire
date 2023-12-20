package io.github.snow.spire.items.intent;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.enemy.Enemy;

/**
 * @author snow
 * @since 2023/12/20
 */
public abstract class BaseIntent implements Intent {
    @Override
    public String toString() {
        return STR."    \{displayName()}：\{description()}";
    }

    @Override
    public Intent simulate(Enemy enemy, FightContext ctx) {
        return this.copy();
    }
}
