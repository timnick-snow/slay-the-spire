package com.example.shell.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 游戏职业角色
 *
 * @author snow
 * @since 2023/12/4
 */
@RequiredArgsConstructor
@Getter
public enum Characters {
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
}
