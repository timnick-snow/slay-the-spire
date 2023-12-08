package com.example.shell.items.relic;

/**
 * 燃烧之血
 *
 * @author snow
 * @since 2023/12/7
 */
public class BurningBlood implements Relic {
    @Override
    public String getName() {
        return "燃烧之血";
    }

    @Override
    public String getDescription() {
        return "在战斗结束时，回复 6 点生命。";
    }
}
