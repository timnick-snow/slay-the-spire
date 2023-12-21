package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MealTicket extends CommonRelic {
    @Override
    public String displayName() {
        return "餐券";
    }

    @Override
    public String description() {
        return "每当你进入商店房间时，回复 15 点生命。";
    }
}
