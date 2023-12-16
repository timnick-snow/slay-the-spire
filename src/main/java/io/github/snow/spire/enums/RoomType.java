package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.Getter;

/**
 * 房间类型
 *
 * @author snow
 * @since 2023/12/4
 */
public enum RoomType implements DisplayAble {
    /**
     * 不明
     */
    UNKNOWN("?"),
    /**
     * 商店
     */
    SHOP("S"),
    /**
     * 财宝
     */
    TREASURE("T"),
    /**
     * 火堆
     */
    REST("R"),
    /**
     * 小怪
     */
    MONSTER("M"),
    /**
     * 精英
     */
    ELITE("E"),
    /**
     * BOSS
     */
    BOSS("BOSS"),
    /**
     * BOSS宝箱
     */
    BOSS_CHEST("CHEST"),
    ;

    private final String symbol;

    RoomType(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String displayName() {
        return symbol;
    }
}
