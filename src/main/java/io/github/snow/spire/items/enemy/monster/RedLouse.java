package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EnemyType;
import io.github.snow.spire.items.core.IntentChance;
import io.github.snow.spire.items.enemy.IntentDecideEnemy;
import io.github.snow.spire.items.intent.AttackIntent;
import io.github.snow.spire.items.intent.BuffStrategic;
import io.github.snow.spire.items.intent.Intent;
import io.github.snow.spire.items.power.Strength;
import io.github.snow.spire.items.power.buff.CurlUp;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/20
 */
public class RedLouse extends IntentDecideEnemy {
    // 生长
    private static final String GROW = "grow";
    // 噬咬
    private static final String BITE = "bite";

    private int x;

    public RedLouse(String id, int difficulty) {
        super(id, difficulty);
    }

/*
有25%的机会使用成长，有75%的机会使用咬合。同一招式不能连续使用三次。
在飞升17+上，它不能连续使用成长两次，也不能连续使用咬合三次

生长：获得3力量             获得4力量
噬咬：随机 X 点伤害         随机 X+1 点伤害

战斗开始时 X 在 5 到 7 之间选择。
 */

    @Override
    protected Map<String, IntentChance> intentCandidate() {
        Map<String, IntentChance> res = new HashMap<>();
        // 生长
        Intent grow = new BuffStrategic(new Strength(difficulty < 17 ? 3 : 4));
        res.put(GROW, new IntentChance(grow, 250, difficulty < 17 ? 2 : 1));
        // 噬咬
        Intent bite = new AttackIntent(x, 1);
        res.put(BITE, new IntentChance(bite, 750, 2));
        return res;
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
    public String name() {
        return "红虱虫";
    }

    @Override
    protected int[] maxHpRange() {
        return new int[]{10, 15};
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.MONSTER;
    }
}
