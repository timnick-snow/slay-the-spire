package io.github.snow.spire.items.potion;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @author snow
 * @since 2023/12/11
 */
@RequiredArgsConstructor
@Slf4j
public abstract class BasePotion implements Potion {
    private final String id;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Potion copy(String id) {
        try {
            Constructor<? extends BasePotion> constructor = this.getClass().getDeclaredConstructor(String.class);
            return constructor.newInstance(id);
        } catch (Exception e) {
            log.error("potion copy error", e);
            return null;
        }
    }
}
