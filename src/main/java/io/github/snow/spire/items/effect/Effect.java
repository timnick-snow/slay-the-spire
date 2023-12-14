package io.github.snow.spire.items.effect;

import io.github.snow.spire.enums.EffectType;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightLifecycle;

/**
 * @author snow
 * @since 2023/12/8
 */
public interface Effect extends DisplayAble, FightLifecycle {
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

    EffectType effectType();

    boolean isStackable();
}
