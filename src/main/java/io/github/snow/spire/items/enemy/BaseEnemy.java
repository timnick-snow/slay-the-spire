package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.BaseFighter;
import io.github.snow.spire.items.power.Power;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;

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
    public void onRoundEnd(FightContext ctx) {
        Iterator<Map.Entry<String, Power>> it = powers.entrySet().iterator();
        while (it.hasNext()) {
            var entry = it.next();
            var power = entry.getValue();
            power.onRoundEnd(ctx);
            if (power.isDead()) {
                it.remove();
            }
        }
    }

    @Override
    public void onRoundStart(FightContext ctx) {
        Iterator<Map.Entry<String, Power>> it = powers.entrySet().iterator();
        while (it.hasNext()) {
            var entry = it.next();
            var power = entry.getValue();
            power.onRoundStart(ctx);
            if (power.isDead()) {
                it.remove();
            }
        }
    }

    @Override
    public String displayName() {
        return "%s %s".formatted(name(), number);
    }

    @Override
    public Enemy copy(String number, int a, int b) {
        try {
            Constructor<? extends BaseEnemy> constructor = this.getClass().getDeclaredConstructor(String.class);
            BaseEnemy baseEnemy = constructor.newInstance(number);
            int[] range = maxHpRange();
            int max = range[0], min = range[1];
            int maxHp = min + a % (max - min + 1);
            baseEnemy.initMaxHp(maxHp);
            return baseEnemy;
        } catch (Exception e) {
            log.error("Enemy copy error", e);
            return null;
        }
    }
}
