package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.Constants;
import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.Effect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author snow
 * @since 2023/12/15
 */
public abstract class BaseFighter implements Fighter {
    protected final String number;
    protected int maxHp;
    protected int hp;
    protected final Map<String, Effect> powers;

    public BaseFighter(String number) {
        this.number = number;
        this.powers = new HashMap<>();
    }

    @Override
    public AttackResult beAttacked(DamageGroup damageGroup, FightContext ctx) {
        // 被攻击
        powers.values().forEach(effect -> effect.onBeAttacked(damageGroup, ctx));
        // 伤害是一段一段触发的
        int num = damageGroup.getNum();
        int base = damageGroup.getBase();

        int total = 0, block = 0;
        for (int i = 0; i < num; i++) {
            ValueWrapper damage = new ValueWrapper(base);
            // 被伤害
            powers.values().forEach(effect -> effect.onGetDamage(damage, ctx));
            int injured = damage.getValue();
            int block0 = base - injured;
            block += block0;
            total += block0;

            int realInjured = injured;
            int oldHp = this.hp;
            if (realInjured > 0) {
                ValueWrapper real = new ValueWrapper(realInjured);
                // 受到真实伤害
                powers.values().forEach(effect -> effect.onGetInjured(real, ctx));
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
    public EffectResult addEffect(EffectAdder effectAdder, FightContext ctx) {
        Effect effect = effectAdder.getEffect();
        if (!effect.isAlive()) {
            return new EffectResult();
        }
        Effect origin = powers.get(effect.id());
        if (origin == null) {
            powers.put(effect.id(), effect);
            // 【邪教徒 e1】 获得了 【易伤 3】
            System.out.printf("【%s】 获得了 【%s】\n", displayName(), effect.displayName());
        } else {
            if (origin.isStackable()) {
                // 【邪教徒 e1】 身上的 【易伤】 增加了：2 -> 5
                int old = origin.amount();
                origin.stack(effect.amount());
                System.out.printf("【%s】 身上的 【%s】 增加了：%d -> %d\n", displayName(), effect.name(), old, origin.amount());
            }
        }
        return new EffectResult();
    }

    @Override
    public List<Effect> powers() {
        return new ArrayList<>(powers.values());
    }

    @Override
    public String number() {
        return number;
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
