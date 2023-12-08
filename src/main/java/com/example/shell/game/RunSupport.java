package com.example.shell.game;

import com.example.shell.enums.Characters;
import com.example.shell.enums.MainPage;
import com.example.shell.items.bless.AddMaxHp;
import com.example.shell.items.bless.Bless;
import com.example.shell.items.bless.GetNeowsBlessing;
import com.example.shell.items.bless.RemoveOne;
import com.example.shell.items.map.FloorRooms;
import com.example.shell.items.map.MapHandler;
import com.example.shell.temp.GameContext;
import com.example.shell.temp.RunContext;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
@Component
public class RunSupport {

    private final GameContext gameContext;
    @Getter
    private RunContext runContext;

    public RunSupport(GameContext gameContext) {
        this.gameContext = gameContext;
    }

    public boolean exist() {
        return gameContext.isRunning();
    }

    public String brief() {
        return runContext.brief();
    }

    public String tips() {
        return runContext.getLastTips();
    }

    /**
     * 生成一个游戏轮回
     */
    public void startRun(Characters role, int level) {
        this.runContext = gameContext.genRun(role, level);
        gameContext.setMainPage(MainPage.GAMING);
    }

    public String roleInfo() {
        String res = "hp: %d/%d  |  金币: %d  |  %s  |  %s  | %s\n";
        return res.formatted(runContext.getHp(), runContext.getMaxHp(), runContext.getGold(),
                runContext.getPotionGroup().formatCount(), runContext.getRelicGroup().formatCount(), runContext.getDeck().formatCount());
    }

    public String position() {
        return "幕: %d\t层: %d\t房间: %d".formatted(runContext.getAct(), runContext.getStair(), runContext.getRoomId());
    }

    public String nextItemId(String prefix) {
        int id = runContext.incrementItemId();
        return "%s%02d".formatted(prefix, id);
    }

    public List<Bless> genBless() {
//        Random eventRandom = runContext.getRandomManage().getEventRandom();
        ArrayList<Bless> list = new ArrayList<>();
        list.add(new AddMaxHp());
        list.add(new GetNeowsBlessing());
        list.add(new RemoveOne());
        return list;
    }

    public void goHint() {
        // tips
        String tips = roleInfo() + "\n";
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += MapHandler.format(floorRooms);
        runContext.setLastTips(tips);
    }
}
