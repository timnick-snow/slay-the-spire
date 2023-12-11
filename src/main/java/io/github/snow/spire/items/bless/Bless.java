package io.github.snow.spire.items.bless;

import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.temp.RunContext;

/**
 * 祝福
 *
 * @author snow
 * @since 2023/12/8
 */
public interface Bless {
    /**
     * 生效
     *
     * @return completed take bless
     */
    boolean run(RunContext ctx, RunSupport support);

    /**
     * 显示信息
     */
    String display(RunContext ctx);

    BlessLevel level();
}
