package com.example.shell.command;

import com.example.shell.enums.MainPage;
import com.example.shell.temp.GameContext;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;

/**
 * @author snow
 * @since 2023/12/8
 */
@Command(group = "Save")
@RequiredArgsConstructor
public class SaveCommand {

    private final GameContext gameContext;

    @Command(command = "sq", description = "save and quit, go back to catalog page.")
    public String saveAndQuit() {
        gameContext.setMainPage(MainPage.CATALOG);
        return "完成。";
    }
}
