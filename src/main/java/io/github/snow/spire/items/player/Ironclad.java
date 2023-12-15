package io.github.snow.spire.items.player;

import io.github.snow.spire.enums.Characters;

/**
 * @author snow
 * @since 2023/12/15
 */
public class Ironclad extends BasePlayer {
    public Ironclad(String number) {
        super(number);
    }

    @Override
    public String displayName() {
        return name() + " " + number;
    }

    @Override
    public String name() {
        return "机甲战士";
    }

    @Override
    public Characters characters() {
        return Characters.IRONCLAD;
    }
}
