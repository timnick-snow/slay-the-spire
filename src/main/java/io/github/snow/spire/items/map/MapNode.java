package io.github.snow.spire.items.map;

import io.github.snow.spire.enums.RoomType;

/**
 * @author snow
 * @since 2023/12/4
 */
public record MapNode(int id, RoomType roomType, int from, int to) {
    public int length() {
        return to - from;
    }
}
