package com.example.shell.beans;

import com.example.shell.enums.RoomType;

import java.util.List;
import java.util.Random;

/**
 * 地图生成
 *
 * @author snow
 * @since 2023/12/4
 */
public class MapHandler {


    @SuppressWarnings("all")
    public static List<MapNode>[][] gen(Random mapRandom) {
        List[] act = new List[17];
        List<MapNode> s0 = List.of(
                new MapNode(RoomType.MONSTER, 0, 2),
                new MapNode(RoomType.MONSTER, 4, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[0] = s0;
        List<MapNode> s1 = List.of(
                new MapNode(RoomType.MONSTER, 0, 1),
                new MapNode(RoomType.UNKNOWN, 1, 4),
                new MapNode(RoomType.MONSTER, 4, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[1] = s1;
        List<MapNode> s2 = List.of(
                new MapNode(RoomType.MONSTER, 0, 2),
                new MapNode(RoomType.UNKNOWN, 3, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[2] = s2;
        List<MapNode> s3 = List.of(
                new MapNode(RoomType.MONSTER, 1, 2),
                new MapNode(RoomType.MONSTER, 2, 4),
                new MapNode(RoomType.UNKNOWN, 4, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[3] = s3;
        List<MapNode> s4 = List.of(
                new MapNode(RoomType.MONSTER, 1, 3),
                new MapNode(RoomType.UNKNOWN, 3, 4),
                new MapNode(RoomType.MONSTER, 4, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[4] = s4;
        List<MapNode> s5 = List.of(
                new MapNode(RoomType.REST, 0, 2),
                new MapNode(RoomType.MONSTER, 2, 3),
                new MapNode(RoomType.REST, 3, 4),
                new MapNode(RoomType.REST, 4, 5),
                new MapNode(RoomType.REST, 5, 6)
        );
        act[5] = s5;
        List<MapNode> s6 = List.of(
                new MapNode(RoomType.MONSTER, 0, 1),
                new MapNode(RoomType.ELITE, 1, 2),
                new MapNode(RoomType.MONSTER, 2, 3),
                new MapNode(RoomType.MONSTER, 3, 6)
        );
        act[6] = s6;
        List<MapNode> s7 = List.of(
                new MapNode(RoomType.REST, 0, 1),
                new MapNode(RoomType.SHOP, 1, 3),
                new MapNode(RoomType.UNKNOWN, 3, 4),
                new MapNode(RoomType.REST, 4, 5),
                new MapNode(RoomType.SHOP, 5, 6)
        );
        act[7] = s7;
        List<MapNode> s8 = List.of(
                new MapNode(RoomType.TREASURE, 0, 4),
                new MapNode(RoomType.TREASURE, 4, 5),
                new MapNode(RoomType.TREASURE, 5, 6)
        );
        act[8] = s8;

        List<MapNode> s9 = List.of(
                new MapNode(RoomType.MONSTER, 0, 1),
                new MapNode(RoomType.ELITE, 1, 2),
                new MapNode(RoomType.MONSTER, 2, 3),
                new MapNode(RoomType.MONSTER, 3, 6)
        );
        act[9] = s9;
        List<MapNode> s10 = List.of(
                new MapNode(RoomType.UNKNOWN, 1, 3),
                new MapNode(RoomType.MONSTER, 3, 5),
                new MapNode(RoomType.MONSTER, 5, 6)
        );
        act[10] = s10;
        List<MapNode> s11 = List.of(
                new MapNode(RoomType.UNKNOWN, 0, 2),
                new MapNode(RoomType.REST, 2, 4),
                new MapNode(RoomType.ELITE, 4, 5),
                new MapNode(RoomType.UNKNOWN, 5, 6)
        );
        act[11] = s11;
        List<MapNode> s12 = List.of(
                new MapNode(RoomType.UNKNOWN, 0, 1),
                new MapNode(RoomType.SHOP, 1, 3),
                new MapNode(RoomType.UNKNOWN, 3, 4),
                new MapNode(RoomType.MONSTER, 4, 5),
                new MapNode(RoomType.UNKNOWN, 5, 6)
        );
        act[12] = s12;
        List<MapNode> s13 = List.of(
                new MapNode(RoomType.MONSTER, 0, 1),
                new MapNode(RoomType.MONSTER, 2, 4),
                new MapNode(RoomType.ELITE, 4, 5),
                new MapNode(RoomType.UNKNOWN, 5, 6)
        );
        act[13] = s13;
        List<MapNode> s14 = List.of(
                new MapNode(RoomType.REST, 0, 1),
                new MapNode(RoomType.REST, 2, 3),
                new MapNode(RoomType.REST, 3, 5),
                new MapNode(RoomType.REST, 5, 6)
        );
        act[14] = s14;
        List<MapNode> s15 = List.of(
                new MapNode(RoomType.BOSS, 0, 6)
        );
        act[15] = s15;

        List[][] res = new List[3][16];
        for (int i = 0; i < 3; i++) {
            res[i] = act;
        }
        return new List[0][];
    }

    public static String format(List<MapNode>[][] map) {
        return null;
    }
}
