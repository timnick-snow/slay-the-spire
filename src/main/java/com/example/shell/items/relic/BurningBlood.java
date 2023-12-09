package com.example.shell.items.relic;

/**
 * 燃烧之血
 *
 * @author snow
 * @since 2023/12/7
 */
public class BurningBlood extends StarterRelic {
    @Override
    public String name() {
        return "燃烧之血";
    }

    @Override
    public String description() {
        return "在战斗结束时，回复 6 点生命。";
    }

}
