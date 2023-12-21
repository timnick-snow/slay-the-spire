package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RedMask extends EventRelic {
    @Override
    public String displayName() {
        return "红面具";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，给予所有敌人 1 层 【虚弱】。";
    }
}
