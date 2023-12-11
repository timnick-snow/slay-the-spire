package io.github.snow.spire.temp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.RunPage;
import io.github.snow.spire.game.*;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.MapHandler;
import io.github.snow.spire.items.reward.Reward;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 游戏轮回
 *
 * @author snow
 * @since 2023/12/4
 */
@Setter
@Getter
public class RunContext {

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
    private final FloorRooms[][] map;
    /**
     * 钥匙 R G B
     */
    private KeyChip keys;
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
    private PotionGroup potionGroup;
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
    private RelicGroup relicGroup;
    /**
     * 卡组
     */
    private Deck deck;

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
    /**
     * 当前房间号
     */
    private int roomId;

    private int itemId;
    private List<Reward> rewards;

    public RunContext(String seed, Characters character, int difficulty) {
        this.map = initRandomGetMap(seed);
        this.seed = seed;
        this.character = character;
        this.difficulty = difficulty;
        this.runPage = RunPage.START_CHOOSE;
        this.potionGroup = new PotionGroup(3);
        this.act = 0;
        this.stair = -1;
        this.roomId = -1;
        this.keys = new KeyChip();

        StarterItem item = StarterItem.redStarter();
        this.hp = item.hp();
        this.maxHp = item.maxHp();
        this.gold = item.gold();
        // 初始遗物
        this.relicGroup = new RelicGroup();
        this.relicGroup.addRelic(item.relic());
        // 初始卡牌
        this.deck = new Deck();
        this.deck.addAll(item.deck());
        this.itemId += item.deck().size();
        this.rewards = Collections.emptyList();
    }

    @SuppressWarnings("all")
    private FloorRooms[][] initRandomGetMap(String seed) {
        this.randomManage = RandomManage.fromSeed(seed);
        var maps = MapHandler.gen(randomManage.getMapRandom());
        return maps;
    }

    public String brief() {
        return "种子编号：%s\n角色：%s\t幕: %d\t层: %d\n".formatted(seed, character.getDisplay(), act + 1, stair + 1);
    }

    @JsonIgnore
    public FloorRooms getCurFloor() {
        if (stair < 0) {
            throw new IllegalStateException("Haven't entered any rooms yet");
        }
        return this.map[act][stair];
    }

    @JsonIgnore
    public FloorRooms getNextFloor() {
        return this.map[act][stair + 1];
    }

    public int incrementItemId() {
        this.itemId++;
        return this.itemId;
    }
}
