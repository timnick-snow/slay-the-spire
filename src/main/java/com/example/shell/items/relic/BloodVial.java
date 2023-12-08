package com.example.shell.items.relic;

public class BloodVial implements Relic{
    @Override
    public String getName() {
        return "小血瓶";
    }

    @Override
    public String getDescription() {
        return "在每场战斗开始时，回复 2 点生命。";
    }
}
