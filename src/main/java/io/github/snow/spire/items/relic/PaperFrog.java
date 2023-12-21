package io.github.snow.spire.items.relic;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023-12-10
 */
public class PaperFrog extends UncommonRelic {
    @Override
    public String displayName() {
        return "纸蛙";
    }

    @Override
    public String description() {
        return "有 【易伤】 状态的敌人受到的伤害增加 75% 而非 50%。";
    }

    @Override
    public Characters classSpecific() {
        return Characters.IRONCLAD;
    }
}
