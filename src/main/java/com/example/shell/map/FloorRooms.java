package com.example.shell.map;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author snow
 * @since 2023/12/6
 */
@Getter
@Setter
public class FloorRooms {
    private List<RoomNode> rooms;
    private int stair;

    public FloorRooms(int stair) {
        this.stair = stair;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(RoomNode roomNode) {
        rooms.add(roomNode);
    }
}
