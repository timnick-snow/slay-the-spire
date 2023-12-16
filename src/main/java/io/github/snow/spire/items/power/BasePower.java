package io.github.snow.spire.items.power;

import io.github.snow.spire.items.core.DisplayAble;

/**
 * @author snow
 * @since 2023/12/14
 */
public abstract class BasePower implements Power {
    protected int num;
    protected final DisplayAble host;

    public BasePower(DisplayAble host, int num) {
        this.host = host;
        this.num = num;
    }

    public BasePower(DisplayAble host) {
        this.host = host;
        this.num = 1;
    }

    @Override
    public String displayName() {
        if (!this.isStackable()) {
            return name();
        }
        return "%s %d".formatted(name(), num);
    }

    @Override
    public void stack(int add) {
        if (!this.isStackable()) {
            throw new IllegalStateException("Can not call addNum because this effect can not stack: "
                    + this.getClass().getSimpleName());
        }
        this.num += add;
    }

    @Override
    public DisplayAble host() {
        return host;
    }

    @Override
    public boolean isAlive() {
        return num > 0;
    }

    @Override
    public int amount() {
        return num;
    }
}