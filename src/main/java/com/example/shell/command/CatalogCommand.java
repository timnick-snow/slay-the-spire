package com.example.shell.command;

import com.example.shell.enums.MainPage;
import com.example.shell.temp.GameContext;
import com.example.shell.temp.GameRunContext;
import org.springframework.shell.Availability;
import org.springframework.shell.component.flow.ComponentFlow;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

/**
 * @author snow
 * @since 2023/12/1
 */
@ShellComponent
public class CatalogCommand {
    final ComponentFlow.Builder componentFlowBuilder;
    final GameContext gameContext;

    public CatalogCommand(ComponentFlow.Builder componentFlowBuilder, GameContext gameContext) {
        this.componentFlowBuilder = componentFlowBuilder;
        this.gameContext = gameContext;
    }


    @ShellMethod(key = {"game"}, value = "帮助")
    public String game() {
        return """
                game start -> 开始游戏
                game continue -> 继续游戏
                game give up -> 放弃当前游戏
                game history -> 历史记录
                """;
    }

    @ShellMethod(key = {"game start"}, value = "开始游戏")
    public String gameStart() {
        if (gameContext.getRunContext().isPresent()) {
            GameRunContext runContext = gameContext.getRunContext().get();
            return "当前有正在进行中的游戏: \n%s".formatted(runContext.brief());
        }
        gameContext.genRun();
        gameContext.setMainPage(MainPage.GAMING);
        return "游戏开始...\n" + gameContext.getRunContext().get().brief();
    }

    @ShellMethod(key = {"game continue"}, value = "继续游戏")
    public String gameContinue() {
        if (gameContext.getRunContext().isEmpty()) {
            return "当前没有进行中的游戏";
        }
        gameContext.setMainPage(MainPage.GAMING);
        return "游戏继续...\n" + gameContext.getRunContext().get().brief();
    }

    @ShellMethod(key = {"game give up"}, value = "放弃当前游戏")
    public String gameGiveUp() {
        if (gameContext.getRunContext().isEmpty()) {
            return "当前没有进行中的游戏";
        }
        gameContext.clearRun();
        gameContext.setMainPage(MainPage.CATALOG);
        return "放弃当前游戏...本剧结算如下: (结算功能暂未完善)";
    }

    @ShellMethod(key = {"game history"}, value = "历史记录")
    public String gameHistory() {
        gameContext.setMainPage(MainPage.HISTORY);
        return "历史记录: xxx(该功能暂未完善)";
    }

    @ShellMethodAvailability()
    public Availability availability() {
        return gameContext.getMainPage().availability(MainPage.CATALOG);
    }
}
