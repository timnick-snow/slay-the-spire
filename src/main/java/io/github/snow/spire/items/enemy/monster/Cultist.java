package io.github.snow.spire.items.enemy.monster;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.enemy.Monster;
import io.github.snow.spire.items.intent.AttackIntent;
import io.github.snow.spire.items.intent.BuffStrategic;
import io.github.snow.spire.items.intent.Intent;
import io.github.snow.spire.items.power.buff.Ritual;

/**
 * @author snow
 * @since 2023/12/14
 */
public class Cultist extends Monster {
    public Cultist(String id, int difficulty) {
        super(id, difficulty);
    }

    @Override
    protected int[] maxHpRange() {
        return new int[]{48, 54};
    }

    @Override
    public String name() {
        return "邪教徒";
    }

    @Override
    public Intent intent(FightContext ctx) {
        if (ctx.getRound2() == 1) {
            Ritual ritual = new Ritual(3);
            return new BuffStrategic(ritual);
        } else {
            return new AttackIntent(6, 1);
        }
    }
}
