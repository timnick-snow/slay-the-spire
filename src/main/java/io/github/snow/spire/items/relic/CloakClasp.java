package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class CloakClasp extends RareRelic {
    @Override
    public String displayName() {
        return "斗篷扣";
    }

    @Override
    public String description() {
        return "在你的回合结束时，每有一张手牌获得 1 点 【格挡】。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
