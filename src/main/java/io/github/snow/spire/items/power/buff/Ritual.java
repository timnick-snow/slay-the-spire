package io.github.snow.spire.items.power.buff;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.EffectTarget;
import io.github.snow.spire.enums.PowerType;
import io.github.snow.spire.items.effect.rough.PowerAdder;
import io.github.snow.spire.items.power.BasePower;
import io.github.snow.spire.items.power.Strength;
import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023/12/19
 */
public class Ritual extends BasePower {

    public Ritual(int num) {
        super(num);
    }

    @Override
    public void onRoundEnd(FightContext ctx) {
        Output.printf("仪式效果触发。");
        PowerAdder adder = new PowerAdder(EffectTarget.SELF, new Strength(amount()));
        host.addPower(adder, ctx);
    }

    @Override
    public String name() {
        return "仪式";
    }

    @Override
    public String description() {
        return "在回合结束时，获得 %d 点力量。".formatted(num);
    }

    @Override
    public String id() {
        return "Ritual";
    }

    @Override
    public PowerType powerType() {
        return PowerType.BUFF;
    }

    @Override
    public boolean isStackable() {
        return true;
    }
}
