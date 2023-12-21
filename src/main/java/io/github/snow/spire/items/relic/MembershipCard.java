package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MembershipCard extends ShopRelic {
    @Override
    public String displayName() {
        return "会员卡";
    }

    @Override
    public String description() {
        return "所有商品打折 50% ！";
    }
}
