package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/16
 */
@RequiredArgsConstructor
public enum CardPosition implements DisplayAble {
    HAND("手牌"),
    DRAW_PILE("抽牌堆"),
    DISCARD_PILE("弃牌堆"),
    EXHAUST_PILE("消耗堆"),
    PLAY_ZONE("待打出区"),
    ;
    private final String display;

    @Override
    public String displayName() {
        return display;
    }
}
