package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class BottledMiracle extends CommonPotion {
    public BottledMiracle(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "瓶装奇迹";
    }

    @Override
    public String getDescription() {
        return "增加 2 张 奇迹 到你的手牌。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
