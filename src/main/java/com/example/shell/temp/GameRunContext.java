package com.example.shell.temp;

import com.example.shell.beans.MapHandler;
import com.example.shell.beans.MapNode;
import com.example.shell.beans.RandomManage;
import com.example.shell.enums.Characters;
import com.example.shell.enums.RunPage;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 游戏轮回
 *
 * @author snow
 * @since 2023/12/4
 */
@Setter
@Getter
public class GameRunContext {

    /**
     * 种子编号
     */
    private final String seed;
    /**
     * 角色
     */
    private final Characters character;
    /**
     * 难度
     */
    private final int difficulty;
    /**
     * 地图
     */
    private final List<MapNode>[][] map;
    /**
     * 钥匙
     */
    private boolean[] keys;
    /**
     * 当前hp
     */
    private int hp;
    /**
     * 最大hp
     */
    private int maxHp;
    /**
     * 金币
     */
    private int gold;
    /**
     * 药水
     */
    private List<String> potions;
    /**
     * 第几幕
     */
    private int act;
    /**
     * 楼层
     */
    private int stair;
    /**
     * 遗物
     */
    private List<String> relics;
    /**
     * 卡组
     */
    private int[] decks;

    /*
     * 开局选项 - 捏奥
     * 看地图
     * way choose
     * 事件/战斗
     */

    /*
    runPage: 捏奥选项  初始楼层 事件中 战斗中 战斗结束
     */

    /**
     * 当前界面
     */
    private RunPage runPage;
    /**
     * 交互提示语
     */
    private String lastTips;
    private RandomManage randomManage;

    public GameRunContext(String seed, Characters character, int difficulty) {
        this.map = initRandomGetMap(seed);
        this.seed = seed;
        this.character = character;
        this.difficulty = difficulty;
        this.runPage = RunPage.START_CHOOSE;
    }

    @SuppressWarnings("all")
    private List<MapNode>[][] initRandomGetMap(String seed) {
        this.randomManage = RandomManage.fromSeed(seed);
        List[][] maps = MapHandler.gen(randomManage.getMapRandom());
        return maps;
    }

    public String brief() {
        return "种子编号：%s\n角色：%s\tAct: %d\tStair: %d\n".formatted(seed, character, act, stair);
    }
}
