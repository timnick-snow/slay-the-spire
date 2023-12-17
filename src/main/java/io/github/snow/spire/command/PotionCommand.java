package io.github.snow.spire.command;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.CommandAvailability;

/**
 * @author snow
 * @since 2023/12/16
 */
@RequiredArgsConstructor
@Command(command = "potion", group = "Potion")
public class PotionCommand {
    @Command(command = "potion", description = "Command about potion.")
    @CommandAvailability(provider = {"availOnGaming", "availOnFight"})
    public String potion() {
        return """
                potion                      ->  关于药水指令的使用指南
                ls potion                   ->  显示当前拥有的药水
                potion discard <id>         ->  丢弃药水
                potion use <id> [-t <tid>]  ->  使用药水。药水作用目标为敌方单体时，需要指定目标
                """;
    }
}
