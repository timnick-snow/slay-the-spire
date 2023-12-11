package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class TwistedFunnel extends ShopRelic {
    @Override
    public String name() {
        return "扭曲漏斗";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，给予所有敌人 4 层 【中毒】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
