package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class EmotionChip extends RareRelic {
    @Override
    public String name() {
        return "情感芯片";
    }

    @Override
    public String description() {
        return "在每回合开始时，如果你在之前回合受到过伤害，则触发所有充能球的被动效果。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
