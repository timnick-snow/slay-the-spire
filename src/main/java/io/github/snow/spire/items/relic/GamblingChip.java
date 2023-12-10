package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class GamblingChip extends RareRelic {
    @Override
    public String name() {
        return "赌博筹码";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，丢弃任意张牌，然后抽相同数量张牌。";
    }
}
