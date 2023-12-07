package com.example.shell.command;

import com.example.shell.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;

/**
 * @author snow
 * @since 2023/12/1
 */
@RequiredArgsConstructor
@Command(command = "game", group = "Game")
public class CatalogCommand {
    private final CatalogService catalogService;

    @Command(description = "help")
    @CommandAvailability(provider = "gameAvail")
    public String game() {
        return """
                game start -> 开始游戏
                game continue -> 继续游戏
                game give up -> 放弃当前游戏
                game history -> 历史记录
                """;
    }

    @Command(command = {"start"}, description = "start to play the game.")
    public String gameStart() {
        return catalogService.start();
    }

    @Command(command = {"continue"}, description = "start to play the game.")
    public String gameContinue() {
        return catalogService.continuation();
    }

    @Command(command = {"give", "up"}, description = "abandon the current game.")
    public String gameGiveUp() {
        return catalogService.giveUp();
    }

    @Command(command = {"history"}, description = "list game history.")
    public String gameHistory() {
        return catalogService.history();
    }

    @Bean
    public AvailabilityProvider gameAvail() {
        return catalogService::availability;
    }
}
