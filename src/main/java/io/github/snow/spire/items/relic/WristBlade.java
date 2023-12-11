package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class WristBlade extends BossRelic {
    @Override
    public String name() {
        return "袖剑";
    }

    @Override
    public String description() {
        return "费用为0的 【攻击牌】 额外造成 4 点伤害。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
