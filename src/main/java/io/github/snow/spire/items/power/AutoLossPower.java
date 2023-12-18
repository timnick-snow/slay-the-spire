package io.github.snow.spire.items.power;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023/12/14
 */
public abstract class AutoLossPower extends BasePower {

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public void onRoundStart(FightContext ctx) {
        int old = this.amount();
        this.stack(-1);
        int res = this.amount();
        // 【邪教徒 e1】 身上的 【易伤】 消失了
        // 【邪教徒 e1】 身上的 【易伤】 减少了：5 -> 4
        String info = "【%s】 身上的 【%s】 ".formatted(this.host().displayName(), this.name());
        if (res > 0) {
            info += "减少了：%d -> %d".formatted(old, res);
        } else {
            info += "消失了";
        }
        Output.println(info);
    }
}
