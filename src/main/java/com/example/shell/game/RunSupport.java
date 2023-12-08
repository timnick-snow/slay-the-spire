package com.example.shell.game;

import com.example.shell.enums.Characters;
import com.example.shell.enums.MainPage;
import com.example.shell.items.potion.StrengthPotion;
import com.example.shell.map.FloorRooms;
import com.example.shell.map.MapHandler;
import com.example.shell.temp.GameContext;
import com.example.shell.temp.RunContext;
import lombok.Getter;
import org.springframework.stereotype.Component;

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

    public void startRun(Characters role, int level) {
        this.runContext = gameContext.genRun(role,level);
        gameContext.setMainPage(MainPage.GAMING);
        // todo 临时测试
        runContext.getPotionGroup().addPotion(new StrengthPotion(nextItemId("p")));

        // tips
        String tips = roleInfo() + "\n";
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += MapHandler.format(floorRooms);
        runContext.setLastTips(tips);
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
}
