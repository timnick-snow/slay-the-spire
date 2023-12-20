package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EnemyType;
import io.github.snow.spire.items.enemy.IntentDecideEnemy;
import io.github.snow.spire.items.intent.Intent;
import io.github.snow.spire.items.power.buff.CurlUp;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/20
 */
public abstract class Louse extends IntentDecideEnemy {
    protected int x;

    public Louse(String number, int difficulty) {
        super(number, difficulty);
    }


    @Override
    public Intent intent(FightContext ctx) {
        return super.decideIntent(ctx);
    }

    @Override
    public void onFightStart(FightContext ctx) {
        Random enemyRandom = ctx.getEnemyRandom();
        this.x = enemyRandom.nextInt(5, 8);
        if (difficulty >= 17) {
            this.x++;
        }
        super.onFightStart(ctx);

        /*
         * 初始能力 - 蜷身
         * 3-7
         * 4-8   lv7+
         * 9-12  lv17+
         */
        int curlUpBlock;
        if (difficulty < 7) {
            curlUpBlock = enemyRandom.nextInt(3, 7);
        } else if (difficulty < 17) {
            curlUpBlock = enemyRandom.nextInt(4, 8);
        } else {
            curlUpBlock = enemyRandom.nextInt(9, 12);
        }
        CurlUp curlUp = new CurlUp(curlUpBlock, this);
        powers.put(curlUp.id(), curlUp);
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.MONSTER;
    }
}
