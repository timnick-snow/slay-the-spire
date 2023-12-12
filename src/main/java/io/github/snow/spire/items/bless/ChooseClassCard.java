package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * @author snow
 * @since 2023/12/8
 */
public class ChooseClassCard implements Bless {

    @Override
    public boolean run(RunContext ctx, RunSupport support) {
        // todo 标准选卡
        return false;
    }

    @Override
    public String display(RunContext ctx) {
        return "选择一张卡牌加入到你的牌组中。";
    }

    @Override
    public BlessLevel level() {
        return BlessLevel.CARD_RELATED;
    }
}
