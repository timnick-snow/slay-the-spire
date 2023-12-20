package io.github.snow.spire.items.player;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.tool.Output;

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

        // lifecycle
        ctx.getRelics().forEach(relic -> relic.onFightStart(ctx));
    }

    @Override
    public void onFightEnd(FightContext ctx) {
        ctx.getRelics().forEach(relic -> relic.onFightEnd(ctx));
        powers().forEach(power -> power.onFightEnd(ctx));
    }

    @Override
    public void onPlayerRoundEnd(FightContext ctx) {
        // lifecycle
        ctx.getRelics().forEach(relic -> relic.onPlayerRoundEnd(ctx));
        powers().forEach(power -> power.onPlayerRoundEnd(ctx));
    }

    @Override
    public void onPlayerRoundStart(FightContext ctx) {
        // 失去格挡
        ValueWrapper blockWrapper = ValueWrapper.of(block);
        ctx.getRelics().forEach(relic -> relic.onBlockAutoLose(blockWrapper, ctx));
        powers().forEach(power -> power.onBlockAutoLose(blockWrapper, ctx));
        loseBlock(blockWrapper.getValue());
        // lifecycle
        ctx.getRelics().forEach(relic -> relic.onPlayerRoundStart(ctx));
        powers().forEach(power -> power.onPlayerRoundStart(ctx));
    }

    private void loseBlock(int value) {
        value = Math.min(value, block);
        if (value > 0) {
            int oldBlock = block;
            this.block -= value;
            Output.println(STR."你失去了 \{value} 格挡，block: \{oldBlock} -> \{block}");
        }
    }

    @Override
    public void heal(int value) {
        value = Math.min(maxHp - hp, value);
        if (value > 0) {
            int oldHp = this.hp;
            this.hp += value;
            Output.println(STR."你回复了 \{value} 生命，hp: \{oldHp} -> \{hp}");
        }
    }

    @Override
    public String displayName() {
        return STR."\{name()} \{number}";
    }
}
