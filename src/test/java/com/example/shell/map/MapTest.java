package com.example.shell.map;

import com.example.shell.tool.JsonUtil;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
public class MapTest {
    @Test
    public void fun1() throws Exception {
        FloorRooms[] floorRooms = MapHandler.genActMap(0, new Random());
        System.out.println(JsonUtil.toJsonString(floorRooms));
    }
}
