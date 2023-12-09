package com.example.shell.items.bless;

import com.example.shell.enums.RelicRarity;

/**
 * @author snow
 * @since 2023/12/8
 */
public class RandomCommonRelic extends RandomRelic {

    @Override
    public RelicRarity rarity() {
        return RelicRarity.COMMON;
    }
}
