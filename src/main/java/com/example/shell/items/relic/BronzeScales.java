package com.example.shell.items.relic;

public class BronzeScales implements Relic{
    @Override
    public String getName() {
        return "铜制鳞片";
    }

    @Override
    public String getDescription() {
        return "在每场战斗开始时，获得 3点 荆棘";
    }
}
