package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class NinjaScroll extends UncommonRelic {
    @Override
    public String name() {
        return "忍术卷轴";
    }

    @Override
    public String description() {
        return "每场战斗开始时，手牌中增加 3 张 【小刀】。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
