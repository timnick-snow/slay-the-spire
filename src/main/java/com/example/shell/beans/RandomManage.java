package com.example.shell.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机中心
 *
 * @author snow
 * @since 2023/12/4
 */
@Getter
public class RandomManage {

    /**
     * 地图随机数 - 生成地图
     */
    private Random mapRandom;

    /**
     * boss随机数 - boss种类/金卡/遗物
     */
    private Random bossRandom;

    /**
     * 遗物随机数 - 非boss遗物
     */
    private Random relicRandom;

    /**
     * 事件随机数 - 问号事件
     */
    private Random eventRandom;

    /**
     * 奖励随机数 - 普通/精英战斗奖励随机数 (卡牌，药水，金币)
     */
    private Random rewardRandom;

    /**
     * 战斗随机数 - 战斗内的随机数1 - 己方
     */
    private Random fightRandom1;
    /**
     * 战斗随机数 - 战斗内的随机数2 - 敌方
     */
    private Random fightRandom2;
    /**
     * 战斗随机数 - 战斗内的随机数3 - 其它
     */
    private Random fightRandom3;

    public static RandomManage fromSeed(String seed) {
        RandomManage randomManage = new RandomManage();

        return randomManage;
    }


    public static String genSeed() {
        StringBuilder seed = new StringBuilder(32);
        for (int i = 0; i < 13; i++) {
            int a = ThreadLocalRandom.current().nextInt(0, 36);
            if (a < 10) {
                seed.append(a);
            } else {
                seed.append((char) (a - 10 + 'A'));
            }
        }
        return seed.toString();
    }


}
