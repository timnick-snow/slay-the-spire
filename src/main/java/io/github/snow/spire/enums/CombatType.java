package io.github.snow.spire.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/13
 */
@RequiredArgsConstructor
@Getter
public enum CombatType {
    NORMAL(0),
    ELITE(1),
    BOSS(2),
    ;
    private final int idx;
}
