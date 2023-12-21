package io.github.snow.spire.items.relic;

/**
 * @author snow
 * @since 2023-12-10
 */
public class LetterOpener extends UncommonRelic {
    @Override
    public String displayName() {
        return "开信刀";
    }

    @Override
    public String description() {
        return "你每在同一回合内打出 3 张【技能牌】，对所有敌人造成 5 点伤害。";
    }
}
