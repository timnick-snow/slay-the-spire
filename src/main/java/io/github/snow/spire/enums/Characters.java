package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.RequiredArgsConstructor;

/**
 * 游戏职业角色
 *
 * @author snow
 * @since 2023/12/4
 */
@RequiredArgsConstructor
public enum Characters implements DisplayAble {
    /**
     * 战士
     */
    IRONCLAD("战士"),
    /**
     * 猎人
     */
    SILENT("猎人"),
    /**
     * 鸡煲
     */
    DEFECT("机器人"),
    /**
     * 关姐
     */
    WATCHER("观者"),
    ;
    private final String display;

    public CardColor color() {
        return switch (this) {
            case IRONCLAD -> CardColor.RED;
            case SILENT -> CardColor.GREEN;
            case DEFECT -> CardColor.BLUE;
            case WATCHER -> CardColor.PURPLE;
        };
    }

    @Override
    public String displayName() {
        return display;
    }
}
