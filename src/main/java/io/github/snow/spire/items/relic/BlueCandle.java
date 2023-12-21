package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class BlueCandle extends UncommonRelic {
    @Override
    public String displayName() {
        return "蓝蜡烛";
    }

    @Override
    public String description() {
        return "可以打出原本不能被打出的 【诅咒牌】 ，打出 【诅咒牌】 会让你失去 1 点生命并将其 【消耗】。";
    }
}
