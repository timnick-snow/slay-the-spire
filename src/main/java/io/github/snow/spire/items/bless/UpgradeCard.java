package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class UpgradeCard implements Bless {
    @Override
    public void run(RunContext ctx, RunSupport support) {
        // todo 升级卡
    }

    @Override
    public String display(RunContext ctx) {
        return "从你的牌组内选择一张牌升级。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.CARD_RELATED;
    }
}