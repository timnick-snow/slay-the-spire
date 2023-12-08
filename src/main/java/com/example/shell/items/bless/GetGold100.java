package com.example.shell.items.bless;

/**
 * @author snow
 * @since 2023/12/8
 */
public class GetGold100 extends GetGold {

    private static final int GOLD_ADD = 100;

    @Override
    protected int getGoldAdd() {
        return GOLD_ADD;
    }
}
