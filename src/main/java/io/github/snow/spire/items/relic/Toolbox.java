package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Toolbox extends ShopRelic {
    @Override
    public String displayName() {
        return "工具箱";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，你可以从 3 张随机无色牌中选择 1 张增加到你的手牌。";
    }
}
