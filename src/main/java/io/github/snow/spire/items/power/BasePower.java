package io.github.snow.spire.items.power;

import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.tool.Output;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;

/**
 * @author snow
 * @since 2023/12/14
 */
@Slf4j
public abstract class BasePower implements Power {
    protected int num;
    @Setter
    protected Fighter host;

    public BasePower(int num) {
        this.num = num;
    }

    public BasePower() {
        this.num = 1;
    }

    protected void trigger() {
        Output.printf(STR."【\{name()}】 触发\n");
    }

    @Override
    public Power copy() {
        try {
            Constructor<? extends BasePower> constructor = this.getClass().getDeclaredConstructor(int.class);
            BasePower basePower = constructor.newInstance(num);
            basePower.setHost(host);
            return basePower;
        } catch (Exception e) {
            log.error("potion copy error", e);
            return null;
        }
    }

    @Override
    public String displayName() {
        if (!this.isStackable()) {
            return name();
        }
        return STR."\{name()}(\{num})";
    }

    @Override
    public void stack(int add) {
        if (!this.isStackable()) {
            throw new IllegalStateException(STR."Can not call addNum because this effect can not stack: \{this.getClass().getSimpleName()}");
        }
        this.num += add;
    }

    @Override
    public DisplayAble host() {
        return host;
    }

    @Override
    public boolean isDead() {
        return num <= 0;
    }

    @Override
    public int amount() {
        return num;
    }
}
