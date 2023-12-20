package io.github.snow.spire.items.core;

import io.github.snow.spire.items.intent.Intent;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    public IntentDecide() {
        this.history = new ArrayList<>();
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
