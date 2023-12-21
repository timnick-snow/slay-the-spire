package io.github.snow.spire.enums;

/**
 * 效果作用目标
 *
 * @author snow
 * @since 2023/12/18
 */
public enum EffectTarget {
    /**
     * 无作用目标
     */
    NONE,
    /**
     * 自身
     */
    SELF,
    /**
     * 单个敌方
     */
    SINGLE_OPPONENT,
    /**
     * 所有敌方
     */
    ALL_OPPONENT,
    /**
     * 随机敌方
     */
    RANDOM_OPPONENT,

    /**
     * 单张手牌
     */
    SINGLE_HAND_CARD,
    /**
     * 所有手牌
     */
    ALL_HAND_CARD,
    /**
     * 所有牌
     */
    ALL_CARD,
}
