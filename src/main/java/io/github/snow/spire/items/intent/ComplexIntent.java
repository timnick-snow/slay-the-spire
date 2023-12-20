package io.github.snow.spire.items.intent;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.RoughEffect;
import io.github.snow.spire.items.enemy.Enemy;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author snow
 * @since 2023/12/20
 */
@RequiredArgsConstructor
public class ComplexIntent extends BaseIntent {
    private final List<Intent> intents;

    @Override
    public String displayName() {
        // 攻击(5×4) + 强化
        return intents.stream()
                .map(DisplayAble::displayName)
                .collect(Collectors.joining(" + "));
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        return intents.stream()
                .flatMap(intent -> intent.getRoughEffect(fighter).stream())
                .toList();
    }

    @Override
    public String description() {
        return displayName();
    }

    @Override
    public String toString() {
        return intents.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public Intent simulate(Enemy enemy, FightContext ctx) {
        List<Intent> simulateList = intents.stream()
                .map(intent -> intent.simulate(enemy, ctx))
                .toList();
        return new ComplexIntent(simulateList);
    }

    @Override
    public Intent copy() {
        List<Intent> list = intents.stream()
                .map(Intent::copy)
                .toList();
        return new ComplexIntent(list);
    }
}
