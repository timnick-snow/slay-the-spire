package io.github.snow.spire.command;

import io.github.snow.spire.service.FightService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

import static org.springframework.shell.command.CommandRegistration.OptionArity.EXACTLY_ONE;

/**
 * @author snow
 * @since 2023/12/15
 */
@RequiredArgsConstructor
@Command(group = "Fight")
public class FightCommand {

    private final FightService fightService;

    @Command(command = "fight", description = "All command on fight.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public String fight() {
        return """
                fight                   ->  战斗内可用命令指南
                play(or p) <hand_id>    ->  打出手牌
                end(or e)               ->  结束回合
                overview                ->  信息概述（敌我双方简要信息、手牌、牌堆）
                power <unit_id>         ->  己方或敌方详细的能力信息（Buff & Debuff）
                draw pile(or a)         ->  查看抽牌堆
                discard pile(or s)      ->  查看弃牌堆
                exhaust pile(or x)      ->  查看消耗堆
                card <card_id>          ->  查看指定卡牌的详细描述
                """;
    }

    @Command(command = "draw pile", alias = "a", description = "List draw pile.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public void drawPile() {
        fightService.drawPile();
    }

    @Command(command = "discard pile", alias = "s", description = "List discard pile.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public void discardPile() {
        fightService.discardPile();
    }

    @Command(command = "exhaust pile", alias = "x", description = "List exhaust pile.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public void exhaustPile() {
        fightService.exhaustPile();
    }

    @Command(command = "overview", description = "Overview.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public void overview() {
        fightService.overview();
    }

    @Command(command = "card", description = "Card detail info.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public String card(
            @Option(shortNames = 'i', required = true, arity = EXACTLY_ONE) String id
    ) {
        return fightService.card(id);
    }

    @Command(command = "play", alias = "p", description = "Play card .")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public String play(
            @Option(shortNames = 'i', required = true, arity = EXACTLY_ONE) String id,
            @Option(shortNames = 't', arity = EXACTLY_ONE) String target
    ) {
        return fightService.playCard(id, target);
    }

    @Bean
    public AvailabilityProvider availOnFight() {
        return fightService::availability;
    }
}
