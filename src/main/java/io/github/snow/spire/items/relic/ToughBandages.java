package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class ToughBandages extends RareRelic {
    @Override
    public String displayName() {
        return "结实绷带";
    }

    @Override
    public String description() {
        return "你每在你的回合丢弃一张牌，就获得 3点 【格挡】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
