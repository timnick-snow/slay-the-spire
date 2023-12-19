package io.github.snow.spire.command;

import io.github.snow.spire.tool.Output;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

/**
 * @author snow
 * @since 2023/12/19
 */
@RequiredArgsConstructor
@Command(command = "setting", group = "Setting")
public class SettingCommand {

    @Command(description = "show setting help.")
    public String setting() {
        return """
                setting                         -> 配置项帮助
                setting speed <speed>           -> 设置战斗速度，0(最慢) - 10(最快)
                """;
    }

    @Command(command = "speed", description = "show setting help.")
    public String speed(@Option(shortNames = 's', required = true) int speed) {
        if (speed < 0 || speed > 10) {
            return "速度范围：0(最慢) - 10(最快)";
        }
        Output.setSpeed(speed);
        return "done.";
    }
}
