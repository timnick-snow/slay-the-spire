package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class RingOfTheSerpent extends BossRelic {
    @Override
    public String name() {
        return "长蛇戒指";
    }

    @Override
    public String description() {
        return "替换 【蛇之戒指】 。在你的每个回合开始时，额外抽 1 张牌。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
