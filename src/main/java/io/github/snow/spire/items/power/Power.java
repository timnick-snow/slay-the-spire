package io.github.snow.spire.items.power;

import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightLifecycle;

/**
 * @author snow
 * @since 2023/12/8
 */
public interface Power extends DisplayAble, FightLifecycle {
    /**
     * 宿主
     */
    DisplayAble host();

    String name();

    String description();

    /**
     * 英文名称标识
     */
    String id();

    PowerType powerType();

    boolean isStackable();

    boolean isDead();

    int amount();

    void stack(int amount);

    Power copy();
}
