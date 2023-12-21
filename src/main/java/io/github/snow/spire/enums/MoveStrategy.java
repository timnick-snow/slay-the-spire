package io.github.snow.spire.enums;

/**
 * 移动策略
 *
 * @author snow
 * @since 2023/12/21
 */
public enum MoveStrategy {
    /**
     * 头部
     */
    FIRST,
    /**
     * 尾部
     */
    LAST,
    /**
     * 随机
     */
    RANDOM,
    /**
     * 移动到尾部，然后洗牌
     */
    SHUFFLE
}
