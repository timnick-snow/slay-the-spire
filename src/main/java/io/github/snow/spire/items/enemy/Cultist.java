package io.github.snow.spire.items.enemy;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.intent.Intent;

/**
 * @author snow
 * @since 2023/12/14
 */
public class Cultist extends Monster {
    public Cultist(String id) {
        super(id);
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
        return null;
    }
}
