package io.github.snow.spire.items.reward;

import io.github.snow.spire.game.RunSupport;

/**
 * @author snow
 * @since 2023/12/11
 */
public interface Reward {
    String display();

    default String verboseDisplay() {
        return display();
    }

    boolean take(RunSupport runSupport);
}
