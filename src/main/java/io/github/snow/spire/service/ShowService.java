package io.github.snow.spire.service;

import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.GameContext;
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
        return runSupport.getRunContext().getPotionGroup().format() + "\n";
    }

    public String decks(boolean verbose) {
        return runSupport.getRunContext().getDeck().format(verbose) + "\n";
    }

    public String position() {
        return runSupport.position() + "\n";
    }

    public String keys() {
        return runSupport.getRunContext().getKeys().format() + "\n";
    }

    public String relics(boolean verbose) {
        return runSupport.getRunContext().getRelicGroup().format(verbose);
    }
}
