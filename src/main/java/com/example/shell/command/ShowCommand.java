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
@Command(command = "show", alias = "sh")
public class ShowCommand {

    private final ShowService showService;

    @Command(command = "", alias = "", description = "show information or item details.")
    @CommandAvailability(provider = "showAvail")
    public String show() {
        return """
                show brief      ->  显示简要信息
                show role       ->  显示角色基本信息
                show keys       ->  显示碎片收集情况
                show potions    ->  显示拥有的药水
                show relics     ->  显示拥有的遗物
                show decks      ->  显示当前的卡组
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

    @Command(command = "keys", alias = "keys", description = "show the keys you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showKeys() {
        return showService.keys();
    }

    @Command(command = "potions", alias = "potions", description = "show the keys you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showPotions() {
        return showService.potions();
    }

    @Command(command = "relics", alias = "relics", description = "show the relics you owned.")
    @CommandAvailability(provider = "showAvail")
    public String showRelics(@Option boolean verbose) {
        return showService.relics();
    }

    @Command(command = "decks", alias = "decks", description = "show decks.")
    @CommandAvailability(provider = "showAvail")
    public String showDecks() {
        return showService.decks();
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
