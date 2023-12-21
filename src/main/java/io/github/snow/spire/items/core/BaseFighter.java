package io.github.snow.spire.items.core;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.effect.finished.BlockEffect;
import io.github.snow.spire.items.effect.rough.BlockChanger;
import io.github.snow.spire.items.effect.rough.DamageGroup;
import io.github.snow.spire.items.effect.rough.Heal;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.Player;
import io.github.snow.spire.items.power.Power;
import io.github.snow.spire.tool.Output;

import java.util.*;

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
            String log = STR."  [\{i + 1}/\{num}] 对 \{call()} 造成 \{base} 伤害，格挡 \{block0} 伤害，损失 \{realInjured} 点生命值。\{statusFormat()}";
            Output.println(log);
            if (this.hp <= 0) {
                break;
            }
        }
        if (this instanceof Enemy && isDie()) {
            // 死亡处理 todo 提取到生命周期中
            Output.println(STR."\{call()} 已阵亡！");
        }
        return new AttackResult(total, blockDamage, isDie());
    }

    @Override
    public void onAfterBeAttacked(AttackResult attackResult, FightContext ctx) {
        powers().forEach(power -> power.onAfterBeAttacked(attackResult, ctx));
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
            Output.println(STR."\{call()} 获得了 【\{power.displayName()}】");
        } else {
            if (origin.isStackable()) {
                // 【邪教徒 e1】 身上的 【易伤】 增加了：2 -> 5
                int old = origin.amount();
                origin.stack(power.amount());
                Output.println(STR."\{call()} 身上的 【\{power.name()}】 增加了：\{old} -> \{origin.amount()}");
            }
        }
        return new PowerResult();
    }

    @Override
    public void changeBlock(BlockChanger blockChanger, FightContext ctx) {
        int add = blockChanger.getBlock();
        if (add < 0) {
            onBlockAutoLose(blockChanger, ctx);
        }
        if (add == 0) {
            return;
        }
        this.block += add;
        String log = STR."\{call()} \{add > 0 ? "增加" : "失去"}了 \{Math.abs(add)} 格挡。\{statusFormat()}";
        Output.println(log);
    }

    @Override
    public void heal(Heal heal, FightContext ctx) {
        int value = heal.getValue();
        value = Math.min(maxHp - hp, value);
        if (value > 0) {
            int oldHp = this.hp;
            this.hp += value;
            Output.println(STR."\{call()} 回复了 \{value} 生命，hp: \{oldHp} -> \{hp}");
        }
    }

    @Override
    public void onPlayerRoundStart(FightContext ctx) {
        // 失去格挡
        SourceChain source = new SourceChain().setFighter(this).setProducer(EffectProducer.GAME_MECHANICS);
        BlockChanger roughEffect = new BlockChanger(-block, source);

        BlockEffect effect = roughEffect.process(Collections.singletonList(this));
        ctx.addEffectTail(effect);
    }

    @Override
    public void onBlockAutoLose(BlockChanger blockChanger, FightContext ctx) {
        powers().forEach(power -> power.onBlockAutoLose(blockChanger, ctx));
    }

    @Override
    public void powerRefresh() {
        powers.entrySet().removeIf(entry -> entry.getValue().isDead());
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

    protected String statusFormat() {
        return STR."当前状态 { hp: \{hp()}/\{maxHp()}, block: \{block()} }";
    }

    protected String call() {
        if (this instanceof Player) {
            return "你";
        }
        return STR."【\{displayName()}】";
    }
}
