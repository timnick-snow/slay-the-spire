package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MutagenicStrength extends EventRelic {
    @Override
    public String displayName() {
        return "突变之力";
    }

    @Override
    public String description() {
        return "在每场战斗开始时获得 3 点 【力量】，在你的第一个回合结束时失去 3 点 【力量】。";
    }
}
