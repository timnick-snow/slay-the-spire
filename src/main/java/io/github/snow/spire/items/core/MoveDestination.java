package io.github.snow.spire.items.core;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.MoveStrategy;

/**
 * @author snow
 * @since 2023/12/21
 */
public record MoveDestination(CardPosition position, MoveStrategy strategy) {
}
