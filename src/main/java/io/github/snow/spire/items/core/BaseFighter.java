package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.rough.BlockAdder;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.tool.Output;

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
    protected final Map<String, Power> powers;
    protected int maxHp;
    protected int hp;
    protected int block;

    public BaseFighter(String number) {
        this.number = number;
        this.powers = new HashMap<>();
    }

    @Override
    public AttackResult beAttacked(DamageGroup damageGroup, FightContext ctx) {
        // 攻击方效果
        damageGroup.getSource().getFighter().powers().forEach(power -> power.onAttack(damageGroup, ctx));
        // 被攻击状态效果
        powers.values().forEach(power -> power.onBeAttacked(damageGroup, ctx));

        // 伤害是一段一段触发的
        int num = damageGroup.getNum();
        int base = damageGroup.getBase();

        int total = 0, blockDamage = 0;
        for (int i = 0; i < num; i++) {
            ValueWrapper damage = new ValueWrapper(base);
            // 受到伤害
            powers.values().forEach(power -> power.onGetDamage(damage, ctx));
            int injured = damage.getValue();
            int block0 = Math.min(injured, block());
            blockDamage += block0;
            total += block0;

            int realInjured = injured - block0;
            this.block -= block0;

            if (realInjured > 0) {
                ValueWrapper real = new ValueWrapper(realInjured);
                // 受到真实伤害
                powers.values().forEach(power -> power.onGetInjured(real, ctx));
                realInjured = Math.min(real.getValue(), this.hp);
                total += realInjured;
                this.hp -= realInjured;
            }
            // [1/2] 对 【邪教徒 e1】 造成 5 伤害，格挡 5 伤害，损失 0 点生命值。 当前状态 { hp: 40/40, block: 1 }
            // [2/2] 对 【邪教徒 e1】 造成 5 伤害，格挡 1 伤害，损失 4 点生命值。 当前状态 { hp: 36/40, block: 0 }
            String log = "  [%d/%d] 对 【%s】 造成 %d 伤害，格挡 %d 伤害，损失 %d 点生命值。 当前状态 { hp: %d/%d, block: %d }"
                    .formatted(i + 1, num, displayName(), base, block0, realInjured, hp(), maxHp(), block());
            Output.println(log);
            if (this.hp <= 0) {
                break;
            }
        }
        return new AttackResult(total, blockDamage, isDie());
    }

    @Override
    public PowerResult addPower(PowerAdder powerAdder, FightContext ctx) {
        Power power = powerAdder.getPower();
        if (power.isDead()) {
            return new PowerResult();
        }
        Power origin = powers.get(power.id());
        if (origin == null) {
            powers.put(power.id(), power);
            // 【邪教徒 e1】 获得了 【易伤(3)】
            Output.println(STR."【\{displayName()}】 获得了 【\{power.displayName()}】");
        } else {
            if (origin.isStackable()) {
                // 【邪教徒 e1】 身上的 【易伤】 增加了：2 -> 5
                int old = origin.amount();
                origin.stack(power.amount());
                Output.println(STR."【\{displayName()}】 身上的 【\{power.name()}】 增加了：\{old} -> \{origin.amount()}");
            }
        }
        return new PowerResult();
    }

    @Override
    public void addBlock(BlockAdder blockAdder) {
        int add = blockAdder.getBlock();
        this.block += add;
        String log = "【%s】 增加了 %d 格挡。 当前状态 { hp: %d/%d, block: %d }"
                .formatted(displayName(), add, hp(), maxHp(), block());
        Output.println(log);
    }

    @Override
    public List<Power> powers() {
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

    @Override
    public int block() {
        return block;
    }

    @Override
    public int blockLossOnRoundStart() {
        return block;
    }

    @Override
    public boolean isDie() {
        return this.hp <= 0;
    }
}
