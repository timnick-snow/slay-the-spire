package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.IntentChance;
import io.github.snow.spire.items.core.IntentDecide;
import io.github.snow.spire.items.intent.Intent;

import java.util.Map;

/**
 * @author snow
 * @since 2023/12/20
 */
public abstract class IntentDecideEnemy extends BaseEnemy {
    protected IntentDecide intentDecide;

    public IntentDecideEnemy(String number, int difficulty) {
        super(number, difficulty);
    }

    protected abstract Map<String, IntentChance> intentCandidate();

    protected Intent decideIntent(FightContext ctx) {
        if (intentDecide.isConfirm()) {
            return intentDecide.getIntent().copy();
        }
        intentDecide.decideRandomly(ctx.getEnemyRandom());
        return intentDecide.getIntent().copy();
    }

    @Override
    public void onFightStart(FightContext ctx) {
        super.onFightStart(ctx);
        this.intentDecide = new IntentDecide(intentCandidate());
    }


    @Override
    public void onRoundEnd(FightContext ctx) {
        super.onRoundEnd(ctx);
        intentDecide.finish();
    }
}
