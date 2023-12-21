package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class NilryCodex extends EventRelic {
    @Override
    public String displayName() {
        return "尼利的宝典";
    }

    @Override
    public String description() {
        return "在每回合结束时，你可以从 3 张随机牌中选择 1 张，随机洗入你的抽牌堆。";
    }
}
