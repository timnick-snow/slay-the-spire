package io.github.snow.spire.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/11
 */
@Getter
@RequiredArgsConstructor
public enum PotionRarity {
    COMMON("普通"),
    UNCOMMON("罕见"),
    RARE("稀有"),
    ;
    private final String display;
}
