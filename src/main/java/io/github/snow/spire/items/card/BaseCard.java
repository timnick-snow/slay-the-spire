package io.github.snow.spire.items.card;

import lombok.Getter;
import lombok.Setter;

/**
 * @author snow
 * @since 2023/12/12
 */
@Getter
public abstract class BaseCard implements Card, Upgradable {
    protected final String id;
    @Setter
    protected int level;

    public BaseCard(String id, int level) {
        this.id = id;
        this.level = level;
    }

    public abstract String baseName();

    @Override
    public String name() {
        String name = baseName();
        if (level == 0) {
            return name;
        } else if (level == 1) {
            return name + "+";
        } else {
            return name + "+" + level;
        }
    }

    @Override
    public int level() {
        return level;
    }

    @Override
    public String id() {
        return id;
    }
}
