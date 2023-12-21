package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class Inserter extends BossRelic {
    @Override
    public String displayName() {
        return "机械臂";
    }

    @Override
    public String description() {
        return "每 2 回合，获得 1 个充能球栏位。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.DEFECT;
    }
}
