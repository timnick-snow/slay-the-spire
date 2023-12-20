package io.github.snow.spire;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.items.enemy.monster.JawWorm;
import io.github.snow.spire.items.intent.Intent;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/4
 */
public class RandomTest implements WithAssertions {

    @Test
    public void fun7() throws Exception {
        JawWorm jawWorm = new JawWorm("e1", 0);
        FightContext ctx = new FightContext(CombatType.NORMAL);
        ctx.setEnemyRandom(new Random());
        jawWorm.onFightStart(ctx);
        
        for (int i = 0; i < 10; i++) {
            Intent intent = jawWorm.intent(ctx);
            System.out.println(intent.displayName());
            jawWorm.onRoundEnd(ctx);
            ctx.round2Add();
        }
    }
}
