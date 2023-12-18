package io.github.snow.spire.items.effect;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DisplayAble;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/17
 */
public interface Effect<T extends DisplayAble> {
    void work(FightContext ctx);

    List<T> getTargets();
}
