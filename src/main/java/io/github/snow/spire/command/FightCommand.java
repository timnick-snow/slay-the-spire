package io.github.snow.spire.command;

import io.github.snow.spire.service.FightService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.AvailabilityProvider;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;

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
                play(or p) <hand_no>    ->  打出手牌
                end(or e)               ->  结束回合
                overview                ->  信息概述（敌我双方简要信息、手牌、牌堆）
                power <unit_no>         ->  己方或敌方详细的能力信息（Buff & Debuff）
                draw pile(or a)         ->  查看抽牌堆
                discard pile(or s)      ->  查看弃牌堆
                exhaust pile(or x)      ->  查看消耗堆
                card <card_no>          ->  查看指定卡牌的详细描述
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

    @Bean
    public AvailabilityProvider availOnFight() {
        return fightService::availability;
    }
}
