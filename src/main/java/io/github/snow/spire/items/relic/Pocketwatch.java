package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Pocketwatch extends RareRelic {
    @Override
    public String name() {
        return "怀表";
    }

    @Override
    public String description() {
        return "若你在某个回合打出的牌少于等于 3 张，则在你的下个回合开始时额外抽 3 张牌。";
    }
}
