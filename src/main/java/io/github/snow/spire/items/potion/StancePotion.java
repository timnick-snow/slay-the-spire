package io.github.snow.spire.items.potion;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-11
 */
public class StancePotion extends UncommonPotion {
    public StancePotion(String id) {
        super(id);
    }

    @Override
    public String getName() {
        return "姿态药水";
    }

    @Override
    public String getDescription() {
        return "进入 平静 或 愤怒 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.WATCHER;
    }
}
