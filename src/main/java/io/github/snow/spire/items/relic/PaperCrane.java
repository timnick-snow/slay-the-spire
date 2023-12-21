package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class PaperCrane extends UncommonRelic {
    @Override
    public String displayName() {
        return "纸鹤";
    }

    @Override
    public String description() {
        return "有 【虚弱】 状态的敌人造成的伤害降低 40% 而非 25% 。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.SILENT;
    }
}
