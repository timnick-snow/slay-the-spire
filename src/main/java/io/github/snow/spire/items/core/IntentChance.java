package io.github.snow.spire.items.core;

import io.github.snow.spire.items.intent.Intent;

/**
 * @author snow
 * @since 2023/12/20
 */
public record IntentChance(Intent intent, int odds, int repeat) {
}
