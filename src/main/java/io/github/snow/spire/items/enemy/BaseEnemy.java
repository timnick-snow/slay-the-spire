package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.Constants;
import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.fight.AttackResult;
import io.github.snow.spire.beans.fight.DamageGroup;
import io.github.snow.spire.beans.fight.EffectResult;
import io.github.snow.spire.beans.fight.ValueWrapper;
import io.github.snow.spire.items.effect.Effect;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * 敌军
 *
 * @author snow
 * @since 2023/12/14
 */
@Slf4j
public abstract class BaseEnemy implements Enemy {
    private final String id;
    private int maxHp;
    private int hp;
    private final List<Effect> powers;


    public BaseEnemy(String id) {
        this.id = id;
        this.maxHp = maxHpRange()[0];
        this.hp = this.maxHp;
        this.powers = new ArrayList<>();
    }

    protected abstract int[] maxHpRange();

    protected void initMaxHp(int maxHp) {
        this.maxHp = maxHp;
        this.hp = maxHp;
    }


    @Override
    public AttackResult beAttacked(DamageGroup damageGroup, FightContext ctx) {
        // 被攻击
        powers.forEach(effect -> effect.onBeAttacked(damageGroup, ctx));
        // 伤害是一段一段触发的
        int num = damageGroup.getNum();
        int base = damageGroup.getBase();

        int total = 0, block = 0;
        for (int i = 0; i < num; i++) {
            ValueWrapper damage = new ValueWrapper(base);
            // 被伤害
            powers.forEach(effect -> effect.onGetDamage(damage, ctx));
            int injured = damage.getValue();
            int block0 = base - injured;
            block += block0;
            total += block0;

            int realInjured = injured;
            int oldHp = this.hp;
            if (realInjured > 0) {
                ValueWrapper real = new ValueWrapper(realInjured);
                // 受到真实伤害
                powers.forEach(effect -> effect.onGetInjured(real, ctx));
                realInjured = real.getValue();
                total += realInjured;
                this.hp -= realInjured;
            }
            String log = Constants.DAMAGE_LOG_TEMPLATE.formatted(i + 1, num, base, block0, realInjured,
                    displayName(), oldHp, this.hp);
            System.out.println(log);
            if (this.hp <= 0) {
                break;
            }
        }
        return new AttackResult(total, block, this.hp <= 0);
    }

    @Override
    public EffectResult addEffect(Effect effect, FightContext ctx) {
        // todo 待定 新状态 状态叠加
        return null;
    }

    @Override
    public String displayName() {
        return "%s %s".formatted(name(), id);
    }

    @Override
    public Enemy copy(String id, int a, int b) {
        try {
            Constructor<? extends BaseEnemy> constructor = this.getClass().getDeclaredConstructor(String.class);
            BaseEnemy baseEnemy = constructor.newInstance(id);
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

    @Override
    public List<Effect> powers() {
        return powers;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public int maxHp() {
        return maxHp;
    }

    @Override
    public int hp() {
        return hp;
    }
}
