package io.github.snow.spire.service;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.reward.Reward;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/11
 */
@Service
@RequiredArgsConstructor
public class RewardService {
    private final RunSupport runSupport;


    public String skip() {
        List<Reward> rewards = runSupport.getRunContext().getRewards();
        if (rewards.isEmpty()) {
            return "当前奖励列表为空。\n";
        }
        runSupport.clearRewards();
        String skipLog = "你跳过了%d项奖励\n".formatted(rewards.size());
        runSupport.goHint();
        return "%s\n%s\n".formatted(skipLog, runSupport.tips());
    }

    public String take(int[] ids) {
        List<Reward> rewards = runSupport.getRunContext().getRewards();
        if (rewards.isEmpty()) {
            return "当前奖励列表为空。\n";
        }
        for (int id : ids) {
            if (id < 0 || id >= rewards.size()) {
                return "奖励 id 不存在。\n";
            }
        }
        List<Reward> takeRewards = new ArrayList<>();
        for (int id : ids) {
            Reward reward = rewards.get(id);
            boolean taken = reward.take(runSupport);
            if (taken) {
                takeRewards.add(reward);
            }
        }
        rewards.removeIf(takeRewards::contains);

        String res = "";
        if (rewards.isEmpty()) {
            if (runSupport.canLeaveRoom()) {
                runSupport.leaveRoom();
                runSupport.goHint();
                res = "\n%s\n".formatted(runSupport.tips());
            }
        }
        return res;
    }
}
