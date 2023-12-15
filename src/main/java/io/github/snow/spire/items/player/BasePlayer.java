package io.github.snow.spire.items.player;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;

/**
 * @author snow
 * @since 2023/12/15
 */
public abstract class BasePlayer extends BaseFighter implements Player {
    public BasePlayer(String number) {
        super(number);
    }

    @Override
    public void onFightStart(FightContext ctx) {
        // 初始化血量
        this.maxHp = ctx.getRunSupport().getRunContext().getMaxHp();
        this.hp = ctx.getRunSupport().getRunContext().getHp();

        // todo 触发遗物
    }
}
