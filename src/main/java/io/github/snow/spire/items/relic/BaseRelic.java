package io.github.snow.spire.items.relic;

import io.github.snow.spire.tool.Output;

/**
 * @author snow
 * @since 2023/12/20
 */
public abstract class BaseRelic implements Relic {

    protected void trigger() {
        Output.printf(STR."【\{displayName()}】 触发\n");
    }
}
