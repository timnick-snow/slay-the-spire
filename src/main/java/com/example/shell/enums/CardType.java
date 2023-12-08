package com.example.shell.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
@Getter
public enum CardType {
    ATTACK("攻击"),
    SKILL("技能"),
    POWER("能力"),
    CURSE("诅咒"),
    ;
    private final String display;

}
