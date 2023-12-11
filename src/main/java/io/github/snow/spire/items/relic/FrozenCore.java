package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class FrozenCore extends BossRelic {
    @Override
    public String name() {
        return "冻结核心";
    }

    @Override
    public String description() {
        return "替换 【破损核心】 。如果你在你的回合结束时还有空余的充能球栏位，生成 1 个 冰霜 充能球。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
