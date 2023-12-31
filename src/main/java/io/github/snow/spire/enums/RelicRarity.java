package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.RequiredArgsConstructor;

/**
 * 遗物稀有度
 *
 * @author snow
 * @since 2023/12/8
 */
@RequiredArgsConstructor
public enum RelicRarity implements DisplayAble {
    STARTER("初始"),
    COMMON("普通"),
    UNCOMMON("罕见"),
    RARE("稀有"),
    BOSS("BOSS"),
    EVENT("事件"),
    SHOP("商店"),
    OTHER("其它"),
    ;
    private final String display;

    @Override
    public String displayName() {
        return display;
    }
}
