package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MedicalKit extends ShopRelic {
    @Override
    public String displayName() {
        return "医药箱";
    }

    @Override
    public String description() {
        return "可以打出原本不能被打出的 【状态牌】 。 打出 【状态牌】 会将其 【消耗】。";
    }
}
