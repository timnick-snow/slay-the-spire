package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MeatOnTheBone extends UncommonRelic {
    @Override
    public String name() {
        return "带骨肉";
    }

    @Override
    public String description() {
        return "如果你在战斗结束时生命值等于或低于 50% ，回复 12 点生命。";
    }
}
