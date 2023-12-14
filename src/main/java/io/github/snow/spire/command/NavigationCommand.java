package io.github.snow.spire.command;

import io.github.snow.spire.service.NavigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

/**
 * @author snow
 * @since 2023/12/14
 */
@RequiredArgsConstructor
@Command(group = "Navigation")
public class NavigationCommand {

    private final NavigationService navigationService;

    @Command(command = "navigation", description = "Navigation.")
    @CommandAvailability(provider = "availOnGaming")
    public String nav() {
        return """
                map             ->  地图
                way             ->  房间连通道路
                """;
    }

    @Command(command = "map", description = "Map.")
    @CommandAvailability(provider = "availOnGaming")
    public String map(
            @Option(shortNames = 's', defaultValue = "0", description = "start floor") int start,
            @Option(shortNames = 'l', defaultValue = "-1", description = "floor count") int limit
    ) {
        start = Math.max(start - 1, 0);
        return navigationService.map(start, limit);
    }

    @Command(command = "way", description = "Way.")
    @CommandAvailability(provider = "availOnGaming")
    public String way(
            @Option(shortNames = 'r', description = "room id") String roomId
    ) {
        return navigationService.way(roomId);
    }

    @Command(command = "go", description = "Go.")
    @CommandAvailability(provider = "availOnGaming")
    public String go(
            @Option(shortNames = 'r', description = "room id", required = true) int roomId
    ) {
        // todo  --skip --fly
        return navigationService.go(roomId);
    }
}
