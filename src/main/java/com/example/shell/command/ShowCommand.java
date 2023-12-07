package com.example.shell.command;

import com.example.shell.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

/**
 * @author snow
 * @since 2023/12/7
 */
@RequiredArgsConstructor
@Command(command = "show", alias = "sh", group = "Show")
public class ShowCommand {

    private final ShowService showService;

    @Command(command = "", alias = "", description = "show information or item details.")
    @CommandAvailability(provider = "showAvail")
    public String show() {
        return """
                show brief      ->  显示简要信息
                show role       ->  显示角色基本信息
                show key        ->  显示碎片收集情况
                show potion     ->  显示拥有的药水
                show relic      ->  显示拥有的遗物
                show deck       ->  显示当前的卡组
                show position   ->  显示当前角色位置
                -------------------------------------
                你可以使用 `show` 的简写命令 `sh`
                """;
    }

    @Command(command = "brief", alias = "brief", description = "show brief of the run.")
    @CommandAvailability(provider = "showAvail")
    public String showBrief() {
        return showService.brief();
    }

    @Command(command = "role", alias = "role", description = "show role base information.")
    @CommandAvailability(provider = "showAvail")
    public String showRole() {
        return showService.roleInfo();
    }

    @Command(command = "key", alias = "key", description = "show the keys you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showKeys() {
        return showService.keys();
    }

    @Command(command = "potion", alias = "potion", description = "show the keys you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showPotions() {
        return showService.potions();
    }

    @Command(command = "relic", alias = "relic", description = "show the relics you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showRelics(@Option(longNames = "verbose", shortNames = 'v') boolean verbose) {
        return showService.relics(verbose);
    }

    @Command(command = "deck", alias = "deck", description = "show deck.")
    @CommandAvailability(provider = "showAvail")
    public String showDecks(@Option(longNames = "verbose", shortNames = 'v') boolean verbose) {
        return showService.decks(verbose);
    }

    @Command(command = "position", alias = "position", description = "show position.")
    @CommandAvailability(provider = "showAvail")
    public String showPosition() {
        return showService.position();
    }

    @Bean
    public AvailabilityProvider showAvail() {
        return showService::availability;
    }
}
