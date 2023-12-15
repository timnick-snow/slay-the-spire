package io.github.snow.spire.items.player;

import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.items.core.BaseFighter;

/**
 * @author snow
 * @since 2023/12/15
 */
public class Silent extends BaseFighter implements Player {
    public Silent(String number) {
        super(number);
    }

    @Override
    public String displayName() {
        return name() + " " + number;
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
