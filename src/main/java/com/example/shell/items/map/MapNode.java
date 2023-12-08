package com.example.shell.items.map;

import com.example.shell.enums.RoomType;

/**
 * @author snow
 * @since 2023/12/4
 */
public record MapNode(int id, RoomType roomType, int from, int to) {
    public int length() {
        return to - from;
    }
}
