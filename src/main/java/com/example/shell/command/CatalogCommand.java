package com.example.shell.command;

import com.example.shell.enums.MainPage;
import com.example.shell.game.RunSupport;
import com.example.shell.service.CatalogService;
import com.example.shell.temp.GameContext;
import com.example.shell.temp.RunContext;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

/**
 * @author snow
 * @since 2023/12/1
 */
@ShellComponent
public class CatalogCommand {
    final GameContext gameContext;
    final RunSupport runSupport;
    final CatalogService catalogService;

    public CatalogCommand(GameContext gameContext, RunSupport runSupport, CatalogService catalogService) {
        this.gameContext = gameContext;
        this.runSupport = runSupport;
        this.catalogService = catalogService;
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
        return catalogService.start();
    }

    @ShellMethod(key = {"game continue"}, value = "继续游戏")
    public String gameContinue() {
        return catalogService.continuation();
    }

    @ShellMethod(key = {"game give up"}, value = "放弃当前游戏")
    public String gameGiveUp() {
        return catalogService.giveUp();
    }

    @ShellMethod(key = {"game history"}, value = "历史记录")
    public String gameHistory() {
        return catalogService.history();
    }

    @ShellMethodAvailability()
    public Availability availability() {
        return catalogService.availability();
    }
}
