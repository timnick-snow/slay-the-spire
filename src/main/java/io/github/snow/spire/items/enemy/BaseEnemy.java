package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.tool.Output;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.List;
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
    public void onPlayerRoundStart(FightContext ctx) {
        super.onPlayerRoundStart(ctx);
        powers().forEach(power -> power.onPlayerRoundStart(ctx));
    }

    @Override
    public void onEnemyRoundEnd(FightContext ctx) {
        powers().forEach(power -> power.onEnemyRoundEnd(ctx));
    }

    @Override
    public void onEnemyRoundStart(FightContext ctx) {
        powers().forEach(power -> power.onEnemyRoundStart(ctx));
    }

    @Override
    public String displayName() {
        return STR."\{name()} \{number}";
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
