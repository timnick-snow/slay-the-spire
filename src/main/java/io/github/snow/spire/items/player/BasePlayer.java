package io.github.snow.spire.items.player;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.HpLoss;

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
        super.onPlayerRoundStart(ctx);
        // lifecycle
        ctx.getRelics().forEach(relic -> relic.onPlayerRoundStart(ctx));
        powers().forEach(power -> power.onPlayerRoundStart(ctx));
    }

    @Override
    public void onBlockAutoLose(BlockChanger blockChanger, FightContext ctx) {
        ctx.getRelics().forEach(relic -> relic.onBlockAutoLose(blockChanger, ctx));
        super.onBlockAutoLose(blockChanger, ctx);
    }

    @Override
    public void onLossHp(HpLoss loss, FightContext ctx) {
        ctx.getRelics().forEach(relic -> relic.onLossHp(loss, ctx));
        super.onLossHp(loss, ctx);
    }

    @Override
    public String displayName() {
        return STR."\{name()} \{number}";
    }
}
