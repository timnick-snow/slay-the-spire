package com.example.shell.beans;

import com.example.shell.enums.RoomType;

/**
 * @author snow
 * @since 2023/12/4
 */
public record MapNode(RoomType roomType, int from, int to) {
}
