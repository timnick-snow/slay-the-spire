package io.github.snow.spire.items;

import io.github.snow.spire.items.reward.Reward;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/11
 */
@Component
public class RewardManager {


    public String format(List<Reward> rewards, boolean verbose) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < rewards.size(); i++) {
            buf.append("  ").append(i + 1).append(" <===> ");
            if (verbose) {
                buf.append(rewards.get(i).verboseDisplay());
            }else {
                buf.append(rewards.get(i).display());
            }
            buf.append("\n");
        }
        return buf.toString();
    }
}
