package io.github.snow.spire.items.player;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023/12/15
 */
public class Watcher extends BasePlayer {
    public Watcher(String number) {
        super(number);
    }

    @Override
    public String name() {
        return "观者";
    }

    @Override
    public Characters characters() {
        return Characters.IRONCLAD;
    }
}
