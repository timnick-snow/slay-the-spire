package io.github.snow.spire.command;

import io.github.snow.spire.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;
import org.springframework.shell.command.annotation.Option;

/**
 * @author snow
 * @since 2023/12/11
 */
@RequiredArgsConstructor
@Command(command = "reward", group = "Reward")
public class RewardCommand {

    private final RewardService rewardService;

    @Command(description = "Deal with the rewards you earn.")
    @CommandAvailability(provider = "availOnGaming")
    public String reward() {
        return """
                reward take <id1> <id2> <id3>   ->  拾取奖励
                reward skip                     ->  放弃剩下的所有奖励
                """;
    }

    @Command(command = "skip", description = "Skip all remaining rewards.")
    @CommandAvailability(provider = "availOnGaming")
    public String rewardSkip() {
        return rewardService.skip();
    }

    @Command(command = "take", description = "Take reward.")
    @CommandAvailability(provider = "availOnGaming")
    public String rewardTake(
            @Option(longNames = "id", shortNames = 'i',
                    description = "reward id", arityMin = 1, arityMax = 5) int[] ids
    ) {
        for (int i = 0; i < ids.length; i++) {
            ids[i] -= 1;
        }
        return rewardService.take(ids);
    }
}
