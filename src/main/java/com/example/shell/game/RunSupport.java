package com.example.shell.game;

import com.example.shell.enums.MainPage;
import com.example.shell.map.FloorRooms;
import com.example.shell.map.MapHandler;
import com.example.shell.temp.GameContext;
import com.example.shell.temp.RunContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
@Component
public class RunSupport {

    private final GameContext gameContext;
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

    public void startRun() {
        this.runContext = gameContext.genRun();
        gameContext.setMainPage(MainPage.GAMING);
        // tips
        String tips = roleInfo();
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += MapHandler.format(floorRooms);
        runContext.setLastTips(tips);
    }

    public String roleInfo() {
        String res = "hp: %d/%d  |  gold: %d  |  potions: %d/%d  |  relics: %d  | decks: %d\n";
        List<String> p = runContext.getPotions();
        return res.formatted(runContext.getHp(), runContext.getMaxHp(), runContext.getGold(),
                p.size(), 3, runContext.getRelics().size(), runContext.getDecks().size());
    }
}
