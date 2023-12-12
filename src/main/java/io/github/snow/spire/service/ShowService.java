package io.github.snow.spire.service;

import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.game.Deck;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.CardManager;
import io.github.snow.spire.items.RewardManager;
import io.github.snow.spire.items.reward.Reward;
import io.github.snow.spire.temp.GameContext;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private final RewardManager rewardManager;
    private final CardManager cardManager;

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
        Deck deck = runSupport.getRunContext().getDeck();
        return cardManager.format(deck.getCards(), verbose) + "\n";
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

    public String reward(boolean verbose) {
        List<Reward> rewards = runSupport.getRunContext().getRewards();
        if (rewards.isEmpty()) {
            return "当前奖励列表为空。\n";
        }
        return rewardManager.format(rewards, verbose);
    }
}
