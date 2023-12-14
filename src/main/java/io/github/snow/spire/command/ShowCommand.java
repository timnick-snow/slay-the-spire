package io.github.snow.spire.command;

import io.github.snow.spire.service.ShowService;
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
@Command(command = "ls", group = "Show")
public class ShowCommand {

    private final ShowService showService;

    @Command(description = "show information or item details.")
    @CommandAvailability(provider = "availOnGaming")
    public String show() {
        return """
                ls brief      ->  显示简要信息
                ls role       ->  显示角色基本信息
                ls key        ->  显示碎片收集情况
                ls potion     ->  显示拥有的药水
                ls relic      ->  显示拥有的遗物
                ls deck       ->  显示卡组
                ls position   ->  显示角色位置
                ls reward     ->  显示可领取的奖励
                """;
    }

    @Command(command = "brief", description = "show brief of the run.")
    @CommandAvailability(provider = "availOnGaming")
    public String showBrief() {
        return showService.brief();
    }

    @Command(command = "role", description = "show role base information.")
    @CommandAvailability(provider = "availOnGaming")
    public String showRole() {
        return showService.roleInfo();
    }

    @Command(command = "key", description = "show the keys you owned.")
    @CommandAvailability(provider = "availOnGaming")
    public String showKeys() {
        return showService.keys();
    }

    @Command(command = "potion", description = "show the keys you owned.")
    @CommandAvailability(provider = "availOnGaming")
    public String showPotions() {
        return showService.potions();
    }

    @Command(command = "relic", description = "show the relics you owned.")
    @CommandAvailability(provider = "availOnGaming")
    public String showRelics(@Option(longNames = "verbose", shortNames = 'v', description = "show details") boolean verbose) {
        return showService.relics(verbose);
    }

    @Command(command = "deck", description = "show deck.")
    @CommandAvailability(provider = "availOnGaming")
    public String showDecks(@Option(longNames = "verbose", shortNames = 'v', description = "show details") boolean verbose) {
        return showService.decks(verbose);
    }

    @Command(command = "position", description = "show position.")
    @CommandAvailability(provider = "availOnGaming")
    public String showPosition() {
        return showService.position();
    }

    @Command(command = "reward", description = "show rewards.")
    @CommandAvailability(provider = "availOnGaming")
    public String showReward(@Option(longNames = "verbose", shortNames = 'v', description = "show details") boolean verbose) {
        return showService.reward(verbose);
    }

    @Bean
    public AvailabilityProvider availOnGaming() {
        return showService::availability;
    }
}
