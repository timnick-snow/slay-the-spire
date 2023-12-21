package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class MarkOfPain extends BossRelic {
    @Override
    public String displayName() {
        return "痛楚印记";
    }

    @Override
    public String description() {
        return "每回合开始时获得一点【能量】 。在战斗开始时，将 2 张 【伤口】 放入你的抽牌堆。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
