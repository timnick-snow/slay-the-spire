package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RunicCapacitor extends ShopRelic {
    @Override
    public String name() {
        return "符文电容器";
    }

    @Override
    public String description() {
        return "每场战斗开始时，获得 3 个额外充能球栏位。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
