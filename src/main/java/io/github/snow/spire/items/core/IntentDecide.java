package io.github.snow.spire.items.core;

import io.github.snow.spire.items.intent.Intent;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * @author snow
 * @since 2023/12/20
 */
@Getter
@Setter
public class IntentDecide {
    private boolean confirm;
    private Intent intent;
    private List<Intent> history;
    private Map<String, IntentChance> candidate;

    public IntentDecide() {
        this(Collections.emptyMap());
    }

    public IntentDecide(Map<String, IntentChance> candidate) {
        this.history = new ArrayList<>();
        this.candidate = candidate;
    }

    public void decideRandomly(Random random) {
        if (candidate.isEmpty()) {
            throw new IllegalStateException("candidate is empty");
        }
        Optional<IntentChance> excludeOpt = candidate.values().stream()
                .filter(this::isExclude).findFirst();
        // 总概率数
        int sumOdds = candidate.values().stream()
                .filter(chance -> excludeOpt.isEmpty() || excludeOpt.get() != chance)
                .map(IntentChance::odds)
                .reduce(0, Integer::sum);
        int value = random.nextInt(0, sumOdds);
        int sum = 0;
        Intent decideIntent = null;
        for (IntentChance chance : candidate.values()) {
            if (excludeOpt.isPresent() && excludeOpt.get() == chance) {
                continue;
            }
            sum += chance.odds();
            if (sum > value) {
                decideIntent = chance.intent();
                break;
            }
        }
        decide(decideIntent);
    }

    private boolean isExclude(IntentChance chance) {
        if (chance.repeat() > 0 && history.size() >= chance.repeat()) {
            for (int j = 1; j <= chance.repeat(); j++) {
                if (history.get(history.size() - j) != chance.intent()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void decide(String key) {
        decide(candidate.get(key).intent());
    }

    public void decide(Intent intent) {
        if (confirm) {
            throw new IllegalStateException("Intent has been determined");
        }
        this.confirm = true;
        this.intent = intent;
    }

    public void finish() {
        if (!confirm) {
            throw new IllegalStateException("Intent is not determined");
        }
        this.confirm = false;
        this.history.add(intent);
    }
}
