package io.github.snow.spire.items.player;

import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.items.core.BaseFighter;

/**
 * @author snow
 * @since 2023/12/15
 */
public class Defect extends BaseFighter implements Player {
    public Defect(String number) {
        super(number);
    }

    @Override
    public String displayName() {
        return name() + " " + number;
    }

    @Override
    public String name() {
        return "故障机器人";
    }

    @Override
    public Characters characters() {
        return Characters.IRONCLAD;
    }
}