package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class CharonAshes extends RareRelic {
    @Override
    public String name() {
        return "卡戎之灰";
    }

    @Override
    public String description() {
        return "每当你 【消耗】 一张牌，对所有敌人造成 3 点伤害。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
