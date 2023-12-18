package io.github.snow.spire.items.card;

import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.RoughEffect;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.util.List;

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

    @Override
    public void upgrade() {
        setLevel(level + 1);
    }

    @Override
    public String displayName() {
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
    public boolean isPlayable() {
        return true;
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
            log.error("card copy error", e);
            return null;
        }
    }

    @Override
    public List<RoughEffect<?>> getRoughEffect(Fighter fighter) {
        throw new UnsupportedOperationException("'%s' not support effect!".formatted(displayName()));
    }
}
