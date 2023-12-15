package io.github.snow.spire.items.core;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/14
 */
@Getter
@Setter
public class DamageGroup {
    /**
     * 伤害来源
     */
    private DisplayAble source;
    /**
     * 基本值
     */
    private int base;
    /**
     * 段数
     */
    private int num;
}
