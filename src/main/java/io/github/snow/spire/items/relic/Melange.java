package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Melange extends ShopRelic {
    @Override
    public String displayName() {
        return "美琅脂";
    }

    @Override
    public String description() {
        return "你每次将抽牌堆洗牌时，【预见】 3.";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
