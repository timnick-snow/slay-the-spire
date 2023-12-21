package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class SneckoSkull extends CommonRelic {
    @Override
    public String displayName() {
        return "异蛇头骨";
    }

    @Override
    public String description() {
        return "每当你给予敌人 中毒 状态时，额外给予 1层 中毒。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
