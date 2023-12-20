package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.ValueWrapper;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.tool.Output;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 敌军
 *
 * @author snow
 * @since 2023/12/14
 */
@Slf4j
public abstract class BaseEnemy extends BaseFighter implements Enemy {
    protected final int difficulty;

    public BaseEnemy(String number, int difficulty) {
        super(number);
        this.maxHp = maxHpRange()[0];
        this.hp = this.maxHp;
        this.difficulty = difficulty;
    }

    protected abstract int[] maxHpRange();

    protected void initMaxHp(int maxHp) {
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    @Override
    public void onFightStart(FightContext ctx) {
        super.onFightStart(ctx);

        Random enemyRandom = ctx.getEnemyRandom();
        int[] range = maxHpRange();
        int min = range[0], max = range[1];
        int maxHp = enemyRandom.nextInt(min, max + 1);
        this.initMaxHp(maxHp);
    }

    @Override
    public void onAfterFightStart(FightContext ctx) {
        List<Power> inbornPowers = powers();
        if (!inbornPowers.isEmpty()) {
            Output.println(STR."注意了！【\{displayName()}】具有天生能力：\{
                    inbornPowers.stream().map(DisplayAble::displayName)
                            .collect(Collectors.joining("，"))
                    }");
        }
    }

    @Override
    public void onRoundEnd(FightContext ctx) {
        powers().forEach(power -> power.onRoundEnd(ctx));
        powerRefresh();
    }

    @Override
    public void onRoundStart(FightContext ctx) {
        // 失去格挡
        ValueWrapper blockWrapper = ValueWrapper.of(block);
        powers().forEach(power -> power.onBlockAutoLose(blockWrapper, ctx));
        loseBlock(blockWrapper.getValue());

        powers().forEach(power -> power.onRoundStart(ctx));
        powerRefresh();
    }

    private void loseBlock(int value) {
        value = Math.min(value, block);
        if (value > 0) {
            int oldBlock = block;
            this.block -= value;
            Output.println(STR."【\{displayName()}】失去了 \{value} 格挡，block: \{oldBlock} -> \{block}");
        }
    }

    @Override
    public String displayName() {
        return "%s %s".formatted(name(), number);
    }

    @Override
    public Enemy copy(String number) {
        try {
            Constructor<? extends BaseEnemy> constructor = this.getClass().getDeclaredConstructor(String.class);
            return constructor.newInstance(number);
        } catch (Exception e) {
            log.error("Enemy copy error", e);
            return null;
        }
    }

    @Override
    public void setHp(int hp) {
        if (hp > maxHp) {
            throw new IllegalArgumentException(STR."Unexpected hp value '\{hp}', the maxHp is \{maxHp}");
        }
        this.hp = hp;
    }
}
