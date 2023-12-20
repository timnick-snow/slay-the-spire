package io.github.snow.spire.items.player;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023/12/15
 */
public class Silent extends BasePlayer {
    public Silent(String number) {
        super(number);
    }

    @Override
    public String name() {
        return "静默猎手";
    }

    @Override
    public Characters characters() {
        return Characters.IRONCLAD;
    }
}
