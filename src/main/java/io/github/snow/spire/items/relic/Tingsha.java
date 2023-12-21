package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Tingsha extends RareRelic {
    @Override
    public String displayName() {
        return "铜钹";
    }

    @Override
    public String description() {
        return "你每在你的回合丢弃一张牌，就对一名随机敌人造成 3 点伤害。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
