package io.github.snow.spire.items.intent;

import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.EffectProducer;

/**
 * @author snow
 * @since 2023/12/19
 */
public interface Intent extends DisplayAble, EffectProducer {

    /**
     * 详细描述
     *
     * @return 意图的详细描述
     */
    String description();
}
