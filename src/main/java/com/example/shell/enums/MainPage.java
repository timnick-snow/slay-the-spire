package com.example.shell.enums;

import lombok.Getter;
import org.springframework.shell.Availability;

/**
 * @author snow
 * @since 2023/12/1
 */
@Getter
public enum MainPage {
    /**
     * 目录界面
     */
    CATALOG("目录界面", "game"),
    /**
     * 游戏轮回
     */
    GAMING("游戏轮回", "play"),
    /**
     * 历史界面
     */
    HISTORY("历史界面", "history"),
    ;
    private final String desc;
    private final String command;

    MainPage(String desc, String command) {
        this.desc = desc;
        this.command = command;
    }

    public Availability availability(MainPage page) {
        if (this == page) {
            return Availability.available();
        }
        return Availability.unavailable(String.format("仅在【%s】中可用。当前处于：%s。请参考命令：%s", page.desc, this.desc, this.command));
    }
}
