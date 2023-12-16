package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
public enum CardColor implements DisplayAble {
    RED("红色"),
    GREEN("绿色"),
    BLUE("蓝色"),
    PURPLE("紫色"),
    COLOURLESS("无色"),
    CURSE("诅咒"),
    ;
    private final String display;

    @Override
    public String displayName() {
        return display;
    }
}
