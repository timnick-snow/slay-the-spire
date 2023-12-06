package com.example.shell.service;

import com.example.shell.enums.MainPage;
import com.example.shell.game.RunSupport;
import com.example.shell.temp.GameContext;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;

/**
 * @author snow
 * @since 2023/12/6
 */
@Service
public class CatalogService {
    private final GameContext gameContext;
    private final RunSupport runSupport;

    public CatalogService(GameContext gameContext, RunSupport runSupport) {
        this.gameContext = gameContext;
        this.runSupport = runSupport;
    }

    public String start() {
        if (runSupport.exist()) {
            return "当前有正在进行中的游戏: \n%s".formatted(runSupport.brief());
        }
        runSupport.startRun();
        return String.format("游戏开始...\n%s\n%s", runSupport.brief(), runSupport.tips());
    }

    public String continuation() {
        if (gameContext.getRunContext().isEmpty()) {
            return "当前没有进行中的游戏";
        }
        gameContext.setMainPage(MainPage.GAMING);
        String brief = "游戏继续...\n" + gameContext.getRunContext().get().brief();
        String tips = gameContext.getRunContext().get().getLastTips();
        return String.format("%s\n%s", brief, tips);
    }

    public String history() {
//        gameContext.setMainPage(MainPage.HISTORY);
        return "历史记录: xxx(该功能暂未完善)";
    }

    public String giveUp() {
        if (!runSupport.exist()) {
            return "当前没有进行中的游戏";
        }
        gameContext.clearRun();
        gameContext.setMainPage(MainPage.CATALOG);
        return "放弃当前游戏...本剧结算如下: (结算功能暂未完善)";
    }

    public Availability availability() {
        return gameContext.getMainPage().availability(MainPage.CATALOG);
    }
}
