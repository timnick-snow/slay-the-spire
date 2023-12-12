package io.github.snow.spire.items.card;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @author snow
 * @since 2023/12/12
 */
@Getter
@Slf4j
public abstract class BaseCard implements UpgradableCard {
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

    @Override
    public Card copy(String id) {
        try {
            Constructor<? extends BaseCard> constructor = this.getClass().getDeclaredConstructor(String.class, int.class);
            return constructor.newInstance(id, level);
        } catch (Exception e) {
            log.error("potion copy error", e);
            return null;
        }
    }
}
