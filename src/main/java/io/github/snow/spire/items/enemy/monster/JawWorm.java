package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EnemyType;
import io.github.snow.spire.items.core.IntentChance;
import io.github.snow.spire.items.enemy.IntentDecideEnemy;
import io.github.snow.spire.items.intent.*;
import io.github.snow.spire.items.power.Strength;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snow
 * @since 2023/12/20
 */
public class JawWorm extends IntentDecideEnemy {

    // 重击
    private static final String CHOMP = "chomp";
    // 盾击
    private static final String THRASH = "thrash";
    // 咆哮
    private static final String BELLOW = "bellow";

    public JawWorm(String id, int difficulty) {
        super(id, difficulty);
    }

    /*
    在第一阶段：塔底中。
        第一回合必定使用重击。
        之后有45%概率使用咆哮，30%概率使用盾击，25%概率使用重击。
        不可能连续三次盾击；不可能连续两次重击；不可能连续两次咆哮

    在第三阶段：深处中。
        所有的大颚虫起始获得3/4/5力量和6/6/9点护甲，相当于一次咆哮的效果。
        其第一回合未必使用重击，而是参照第一阶段的规律进行攻击。
     */
    @Override
    protected Map<String, IntentChance> intentCandidate() {
        Map<String, IntentChance> res = new HashMap<>();
        // 重击
        Intent chomp = new AttackIntent(11, 1);
        res.put(CHOMP, new IntentChance(chomp, 250, 1));

        // 盾击
        Intent attack = new AttackIntent(7, 1);
        Intent block = new DefendIntent(5);
        Intent thrash = new ComplexIntent(List.of(attack, block));
        res.put(THRASH, new IntentChance(thrash, 300, 2));

        // 咆哮
        Intent power = new BuffStrategic(new Strength(3));
        Intent bellowBlock = new DefendIntent(6);
        Intent bellow = new ComplexIntent(List.of(power, bellowBlock));
        res.put(BELLOW, new IntentChance(bellow, 450, 1));

        return res;
    }

    @Override
    public Intent intent(FightContext ctx) {
        if (!intentDecide.isConfirm() && ctx.getRound2() == 1) {
            // 第一回合
            intentDecide.decide(CHOMP);
        }
        return super.decideIntent(ctx);
    }

    @Override
    public String name() {
        return "大颚虫";
    }

    @Override
    protected int[] maxHpRange() {
        return new int[]{40, 44};
    }

    @Override
    public EnemyType enemyType() {
        return EnemyType.MONSTER;
    }
}
