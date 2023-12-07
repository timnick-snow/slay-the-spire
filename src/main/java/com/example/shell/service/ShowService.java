package com.example.shell.service;

import com.example.shell.enums.MainPage;
import com.example.shell.game.RunSupport;
import com.example.shell.temp.GameContext;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author snow
 * @since 2023/12/7
 */
@Service
@RequiredArgsConstructor
@Component
public class ShowService {
    private final GameContext gameContext;
    private final RunSupport runSupport;

    public Availability availability() {
        return gameContext.getMainPage().availability(MainPage.GAMING);
    }

    public String brief() {
        return runSupport.brief();
    }

    public String roleInfo() {
        return runSupport.roleInfo();
    }

    public String potions() {
        return runSupport.getRunContext().getPotions().format() + "\n";
    }

    public String decks() {
        return null;
    }

    public String position() {
        return runSupport.position();
    }

    public String keys() {
        return runSupport.getRunContext().getKeys().format() + "\n";
    }

    public String relics() {
        return null;
    }
}
