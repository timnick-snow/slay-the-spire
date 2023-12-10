package io.github.snow.spire.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
@Getter
public enum CardRarity {
    STARTER("初始"),
    COMMON("普通"),
    UNCOMMON("罕见"),
    RARE("稀有"),
    CURSE("诅咒"),
    SPECIAL("特殊"),
    ;
    private final String display;
}
