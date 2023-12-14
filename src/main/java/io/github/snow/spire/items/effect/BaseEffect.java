package io.github.snow.spire.items.effect;

import io.github.snow.spire.items.core.DisplayAble;
import lombok.Getter;

/**
 * @author snow
 * @since 2023/12/14
 */
@Getter
public abstract class BaseEffect implements Effect {
    private int num;
    private final DisplayAble host;

    public BaseEffect(DisplayAble host, int num) {
        this.host = host;
        this.num = num;
    }

    public BaseEffect(DisplayAble host) {
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

    public void addNum(int add) {
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
}
