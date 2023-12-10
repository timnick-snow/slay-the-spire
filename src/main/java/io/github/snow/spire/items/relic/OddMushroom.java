package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class OddMushroom extends EventRelic {
    @Override
    public String name() {
        return "奇怪蘑菇";
    }

    @Override
    public String description() {
        return "当你有 【易伤】 状态时，受到的额外伤害从 50% 下降为 25% 。";
    }
}
