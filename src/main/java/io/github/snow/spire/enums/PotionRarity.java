package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/11
 */
@RequiredArgsConstructor
public enum PotionRarity implements DisplayAble {
    COMMON("普通"),
    UNCOMMON("罕见"),
    RARE("稀有"),
    ;
    private final String display;

    @Override
    public String displayName() {
        return display;
    }
}
