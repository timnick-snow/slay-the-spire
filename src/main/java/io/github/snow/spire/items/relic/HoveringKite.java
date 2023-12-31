package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class HoveringKite extends BossRelic {
    @Override
    public String displayName() {
        return "悬浮风筝";
    }

    @Override
    public String description() {
        return "你在每回合第一次弃牌时，获得1点 【能量】 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
