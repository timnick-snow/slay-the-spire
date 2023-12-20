package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.items.core.IntentChance;
import io.github.snow.spire.items.intent.AttackIntent;
import io.github.snow.spire.items.intent.DebuffStrategic;
import io.github.snow.spire.items.intent.Intent;
import io.github.snow.spire.items.power.debuff.Weak;

import java.util.HashMap;
import java.util.Map;

/**
 * @author snow
 * @since 2023/12/20
 */
public class GreenLouse extends Louse {
    // 吐网
    private static final String SPIT_WEB = "spitWeb";
    // 噬咬
    private static final String BITE = "bite";

    public GreenLouse(String id, int difficulty) {
        super(id, difficulty);
    }

/*
有 25% 的机会使用 吐网，有 75% 的机会使用 咬。同一招式不能连续使用三次。
在飞升17+上，它不能连续使用 吐网两次，也不能连续使用咬三次。

吐网：施加2脆弱
噬咬：随机 X 点伤害         随机 X+1 点伤害

战斗开始时 X 在 5 到 7 之间选择。
 */

    @Override
    protected Map<String, IntentChance> intentCandidate() {
        Map<String, IntentChance> res = new HashMap<>();
        // 吐网
        Intent spitWeb = new DebuffStrategic(new Weak(2));
        res.put(SPIT_WEB, new IntentChance(spitWeb, 250, difficulty < 17 ? 2 : 1));
        // 噬咬
        Intent bite = new AttackIntent(x, 1);
        res.put(BITE, new IntentChance(bite, 750, 2));
        return res;
    }

    @Override
    public String name() {
        return "绿虱虫";
    }

    @Override
    protected int[] maxHpRange() {
        if (difficulty < 7) {
            return new int[]{11, 17};
        } else {
            return new int[]{12, 18};
        }
    }
}
