package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023/12/9
 */
public class BloodVial extends CommonRelic {
    @Override
    public String name() {
        return "小血瓶";
    }

    @Override
    public String description() {
        return "在每场战斗开始时，回复 2 点生命。";
    }

}
