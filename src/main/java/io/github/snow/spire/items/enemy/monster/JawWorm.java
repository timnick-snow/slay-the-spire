package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.IntentDecide;
import io.github.snow.spire.items.enemy.Monster;
import io.github.snow.spire.items.intent.*;
import io.github.snow.spire.items.power.Strength;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/20
 */
public class JawWorm extends Monster {

    private final IntentDecide intentDecide;
    // 重击
    private Intent chomp;
    // 盾击
    private Intent thrash;
    // 咆哮
    private Intent bellow;

    public JawWorm(String id, int difficulty) {
        super(id, difficulty);
        this.intentDecide = new IntentDecide();
        initIntent();
    }

    private void initIntent() {
        // 重击
        chomp = new AttackIntent(11, 1);

        // 盾击
        Intent attack = new AttackIntent(7, 1);
        Intent block = new DefendIntent(5);
        thrash = new ComplexIntent(List.of(attack, block));

        // 咆哮
        Intent power = new BuffStrategic(new Strength(3));
        Intent bellowBlock = new DefendIntent(6);
        bellow = new ComplexIntent(List.of(power, bellowBlock));
    }

    @Override
    public String name() {
        return "大颚虫";
    }

    @Override
    protected int[] maxHpRange() {
        return new int[]{40, 44};
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
    public Intent intent(FightContext ctx) {
        if (intentDecide.isConfirm()) {
            return intentDecide.getIntent().copy();
        }
        // 第一回合
        if (ctx.getRound2() == 1) {
            intentDecide.decide(chomp);
            return chomp.copy();
        }
        // 之后的回合
        List<Intent> history = intentDecide.getHistory();
        if (history.getLast() == chomp) {
            // 不能使用重击
            int value = ctx.getEnemyRandom().nextInt(0, 75);
            if (value < 45) {
                intentDecide.decide(bellow);
            } else {
                intentDecide.decide(thrash);
            }
        } else if (history.getLast() == bellow) {
            // 不能使用咆哮
            int value = ctx.getEnemyRandom().nextInt(0, 55);
            if (value < 30) {
                intentDecide.decide(thrash);
            } else {
                intentDecide.decide(chomp);
            }
        } else {
            if (history.size() > 1 && history.get(history.size() - 2) == thrash) {
                // 不能再使用盾击了
                int value = ctx.getEnemyRandom().nextInt(0, 70);
                if (value < 45) {
                    intentDecide.decide(bellow);
                } else {
                    intentDecide.decide(chomp);
                }
            } else {
                // 无限制
                int value = ctx.getEnemyRandom().nextInt(0, 100);
                if (value < 45) {
                    intentDecide.decide(bellow);
                } else if (value < 75) {
                    intentDecide.decide(thrash);
                } else {
                    intentDecide.decide(chomp);
                }
            }
        }
        return intentDecide.getIntent().copy();
    }

    @Override
    public void onRoundEnd(FightContext ctx) {
        super.onRoundEnd(ctx);
        intentDecide.finish();
    }
}
