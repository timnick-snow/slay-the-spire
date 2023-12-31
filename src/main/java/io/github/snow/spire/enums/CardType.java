package io.github.snow.spire.enums;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
public enum CardType implements DisplayAble {
    ATTACK("攻击"),
    SKILL("技能"),
    POWER("能力"),
    CURSE("诅咒"),
    STATUS("状态"),
    ;
    private final String display;

    @Override
    public String displayName() {
        return display;
    }
}
