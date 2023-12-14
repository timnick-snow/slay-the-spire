package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.temp.RunContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/14
 */
@Component
public class BossManager {
    private Random bossRandom;
    private String[] boss;

    private static final String[][] BOSS_ARR = {
            {"六火亡魂", "守护者", "史莱姆老大"},
            {"第一勇士", "铜制机械人偶", "收藏家"},
            {"八体＆甜圈", "觉醒者", "时间吞噬者"},
    };

    public String getBoss(int act) {
        return boss[act];
    }

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.bossRandom = source.getRandomManage().getBossRandom();
        this.boss = new String[4];
        initBoss();
    }

    private void initBoss() {
        for (int i = 0; i < 3; i++) {
            int value = bossRandom.nextInt(0, 1000);
            boss[i] = BOSS_ARR[i][value % 3];
        }
        int value = bossRandom.nextInt(0, 1000);
        boss[3] = BOSS_ARR[2][value % 3];
    }
}
