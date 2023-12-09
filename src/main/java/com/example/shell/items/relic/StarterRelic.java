package com.example.shell.items.relic;

import com.example.shell.enums.RelicRarity;

/**
 * @author snow
 * @since 2023/12/9
 */
public abstract class StarterRelic implements Relic {
    @Override
    public RelicRarity rarity() {
        return RelicRarity.STARTER;
    }
}
