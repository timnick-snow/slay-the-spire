package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Necronomicon extends EventRelic {
    @Override
    public String name() {
        return "死灵之书";
    }

    @Override
    public String description() {
        return "你每回合打出的第一张耗能大于等于 2 的 【攻击牌】 将被打出两次。当你拾起这件遗物时，获得 【死灵诅咒】 。";
    }
}
