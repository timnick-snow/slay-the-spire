package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class CrackedCore extends StarterRelic {
    @Override
    public String name() {
        return "破损核心";
    }

    @Override
    public String description() {
        return "在每场战斗开始时， 生成 1 个 【闪电】 充能球。";
    }
}
