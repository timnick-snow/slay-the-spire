package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Cables extends UncommonRelic {
    @Override
    public String name() {
        return "镀金缆线";
    }

    @Override
    public String description() {
        return "你最右侧的充能球会额外触发一次被动效果。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
