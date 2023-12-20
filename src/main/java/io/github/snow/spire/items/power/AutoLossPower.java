package io.github.snow.spire.items.power;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.tool.Output;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/14
 */
@Setter
public abstract class AutoLossPower extends BasePower {

    private boolean keep;

    @Override
    public boolean isStackable() {
        return true;
    }

    @Override
    public void onPlayerRoundStart(FightContext ctx) {
        if (keep) {
            this.keep = false;
            return;
        }
        int old = this.amount();
        this.stack(-1);
        int res = this.amount();
        // 【邪教徒 e1】 身上的 【易伤】 消失了
        // 【邪教徒 e1】 身上的 【易伤】 减少了：5 -> 4
        String info = STR."【\{host.displayName()}】 身上的 【\{name()}】 ";
        if (res > 0) {
            info += STR."减少了：\{old} -> \{res}";
        } else {
            info += "消失了";
        }
        Output.println(info);
    }
}
