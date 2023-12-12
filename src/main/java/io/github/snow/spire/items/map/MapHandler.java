package io.github.snow.spire.items.map;

import io.github.snow.spire.enums.RoomType;
import io.github.snow.spire.tool.RandomUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;

/**
 * 地图生成
 *
 * @author snow
 * @since 2023/12/4
 */
@Slf4j
public class MapHandler {
    /*
    1点：0	 0  5  40  55
2点：0     2  45 40  13
3点：3	17  60 17  3
4点：3  17    60  17    3
5点：6 19 60 14 1
6点：9 21 60 10 0

     */
    //

    /**
     * 初始层房间数量
     */
    static final int[] FIRST_ROOM_ODDS = {0, 1, 100, 600, 250, 40, 9};
    /**
     * 楼层房间数变化
     */
    static final int[][] ROOM_CHANGE_ODDS = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 49, 950, 0, 0, 0},
            {0, 10, 39, 150, 650, 150, 1},
            {0, 1, 20, 250, 550, 150, 29},
            {0, 0, 20, 200, 460, 280, 40},
            {0, 0, 45, 220, 490, 200, 45},
            {0, 0, 1, 160, 500, 330, 9},
    };


    @SuppressWarnings("all")
    public static FloorRooms[][] gen(Random mapRandom) {
        FloorRooms[][] res = new FloorRooms[3][16];
        for (int i = 0; i < 3; i++) {
            res[i] = genActMap(i, mapRandom);
        }
        return res;
    }

    static FloorRooms[] genActMap(int act, Random mapRandom) {
        int[] rooms = rooms(mapRandom);
        FloorRooms[] res = new FloorRooms[rooms.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = new FloorRooms(act * 17 + i + 1);
            if (i == res.length - 1) {
                // 处理boss层
                RoomNode bossRoom = new RoomNode(res[i].getStair() * 100 + 1);
                bossRoom.setRoomType(RoomType.BOSS);
                res[i].addRoom(bossRoom);

                for (RoomNode room : res[i - 1].getRooms()) {
                    room.addParentNode(bossRoom);
                }
            } else {
                for (int j = 0; j < rooms[i]; j++) {
                    RoomNode roomNode = new RoomNode(res[i].getStair() * 100 + j + 1);
                    roomNode.setRoomType(RoomType.UNKNOWN);
                    res[i].addRoom(roomNode);
                }
                if (i > 0) {
                    connect(res[i - 1], res[i], mapRandom);
                }
            }
        }

        return res;
    }

    private static void connect(FloorRooms child, FloorRooms parent, Random random) {
        int from = child.getRooms().size();
        int to = parent.getRooms().size();
        List<List<Integer>> strategy = WayBranch.strategy(from, to, random);
        for (int i = 0; i < strategy.size(); i++) {
            List<RoomNode> childRooms = child.getRooms();
            RoomNode c = childRooms.get(i);
            List<RoomNode> rooms = parent.getRooms();
            for (Integer pid : strategy.get(i)) {
                c.addParentNode(rooms.get(pid));
            }
        }
    }

    static int[] rooms(Random mapRandom) {
        int[] res = new int[16];
        int x = RandomUtil.randomIndex(FIRST_ROOM_ODDS, mapRandom.nextInt(0, 1000));
        res[0] = x;
        for (int i = 1; i < res.length; i++) {
            res[i] = RandomUtil.randomIndex(ROOM_CHANGE_ODDS[res[i - 1]], mapRandom.nextInt(0, 1000));
        }
        res[res.length - 1] = 1;
        return res;
    }

    public static String format(FloorRooms floorRooms) {
        StringBuilder buf = new StringBuilder();
        for (RoomNode room : floorRooms.getRooms()) {
            buf.append(room.getId()).append("  ").append(room.getRoomType().getSymbol());
            if (!room.getNext().isEmpty()) {
                buf.append(" -> ");
                if (room.getNext().size() == 1) {
                    buf.append(room.getNext().getFirst().getRoomType().getSymbol());
                } else {
                    buf.append("(");
                    for (RoomNode nextRoom : room.getNext()) {
                        buf.append(nextRoom.getRoomType().getSymbol()).append(",");
                    }
                    buf.deleteCharAt(buf.length() - 1);
                    buf.append(")");
                }
                if (!room.getNext().getFirst().getPids().isEmpty()) {
                    buf.append(" -> ...");
                }
            }
            buf.append("\n");
        }
        return buf.toString();
    }


    public static String format(List<MapNode>[] map) {
        StringBuilder sb = new StringBuilder(512);
        for (int i = map.length - 1; i >= 0; i--) {
            List<MapNode> nodes = map[i];
            int from = 0;
            for (MapNode node : nodes) {
                int offset = node.from() - from;
                if (offset > 0) {
                    int space = from == 0 ? 5 * offset : 5 * offset - 1;
                    sb.append(" ".repeat(space))
                            .append("|");
                } else if (from == 0) {
                    sb.append("|");
                }
                // 居中对其
                String text = node.roomType().getSymbol();
                int width = node.length() * 5 - 1;
                int space = width - text.length();
                sb.append(" ".repeat(space / 2))
                        .append(text)
                        .append(" ".repeat((space + 1) / 2))
                        .append("|");
                from = node.to();
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("U - 未知\t\t");
        sb.append("S - 商店\n");
        sb.append("T - 财宝\t\t");
        sb.append("R - 火堆\n");
        sb.append("M - 小怪\t\t");
        sb.append("E - 精英\n");
        sb.append("\n");
        return sb.toString();
    }

    private static List[] demo() {
        List[] act = new List[16];
        List<MapNode> s0 = List.of(
                new MapNode(0, RoomType.MONSTER, 0, 2),
                new MapNode(1, RoomType.MONSTER, 4, 5),
                new MapNode(2, RoomType.MONSTER, 5, 6)
        );
        act[0] = s0;
        List<MapNode> s1 = List.of(
                new MapNode(3, RoomType.MONSTER, 0, 1),
                new MapNode(4, RoomType.UNKNOWN, 1, 4),
                new MapNode(5, RoomType.MONSTER, 4, 5),
                new MapNode(6, RoomType.MONSTER, 5, 6)
        );
        act[1] = s1;
        List<MapNode> s2 = List.of(
                new MapNode(7, RoomType.MONSTER, 0, 2),
                new MapNode(8, RoomType.UNKNOWN, 3, 5),
                new MapNode(9, RoomType.MONSTER, 5, 6)
        );
        act[2] = s2;
        List<MapNode> s3 = List.of(
                new MapNode(10, RoomType.MONSTER, 1, 2),
                new MapNode(11, RoomType.MONSTER, 2, 4),
                new MapNode(12, RoomType.UNKNOWN, 4, 5),
                new MapNode(13, RoomType.MONSTER, 5, 6)
        );
        act[3] = s3;
        List<MapNode> s4 = List.of(
                new MapNode(14, RoomType.MONSTER, 1, 3),
                new MapNode(15, RoomType.UNKNOWN, 3, 4),
                new MapNode(16, RoomType.MONSTER, 4, 5),
                new MapNode(17, RoomType.MONSTER, 5, 6)
        );
        act[4] = s4;
        List<MapNode> s5 = List.of(
                new MapNode(18, RoomType.REST, 0, 2),
                new MapNode(19, RoomType.MONSTER, 2, 3),
                new MapNode(20, RoomType.REST, 3, 4),
                new MapNode(21, RoomType.REST, 4, 5),
                new MapNode(22, RoomType.REST, 5, 6)
        );
        act[5] = s5;
        List<MapNode> s6 = List.of(
                new MapNode(23, RoomType.MONSTER, 0, 1),
                new MapNode(24, RoomType.ELITE, 1, 2),
                new MapNode(25, RoomType.MONSTER, 2, 3),
                new MapNode(26, RoomType.MONSTER, 3, 6)
        );
        act[6] = s6;
        List<MapNode> s7 = List.of(
                new MapNode(27, RoomType.REST, 0, 1),
                new MapNode(28, RoomType.SHOP, 1, 3),
                new MapNode(29, RoomType.UNKNOWN, 3, 4),
                new MapNode(30, RoomType.REST, 4, 5),
                new MapNode(31, RoomType.SHOP, 5, 6)
        );
        act[7] = s7;
        List<MapNode> s8 = List.of(
                new MapNode(32, RoomType.TREASURE, 0, 4),
                new MapNode(33, RoomType.TREASURE, 4, 5),
                new MapNode(34, RoomType.TREASURE, 5, 6)
        );
        act[8] = s8;

        List<MapNode> s9 = List.of(
                new MapNode(35, RoomType.MONSTER, 0, 1),
                new MapNode(1, RoomType.ELITE, 1, 2),
                new MapNode(1, RoomType.MONSTER, 2, 3),
                new MapNode(1, RoomType.MONSTER, 3, 6)
        );
        act[9] = s9;
        List<MapNode> s10 = List.of(
                new MapNode(1, RoomType.UNKNOWN, 1, 3),
                new MapNode(1, RoomType.MONSTER, 3, 5),
                new MapNode(1, RoomType.MONSTER, 5, 6)
        );
        act[10] = s10;
        List<MapNode> s11 = List.of(
                new MapNode(1, RoomType.UNKNOWN, 0, 2),
                new MapNode(1, RoomType.REST, 2, 4),
                new MapNode(1, RoomType.ELITE, 4, 5),
                new MapNode(1, RoomType.UNKNOWN, 5, 6)
        );
        act[11] = s11;
        List<MapNode> s12 = List.of(
                new MapNode(1, RoomType.UNKNOWN, 0, 1),
                new MapNode(1, RoomType.SHOP, 1, 3),
                new MapNode(1, RoomType.UNKNOWN, 3, 4),
                new MapNode(1, RoomType.MONSTER, 4, 5),
                new MapNode(1, RoomType.UNKNOWN, 5, 6)
        );
        act[12] = s12;
        List<MapNode> s13 = List.of(
                new MapNode(1, RoomType.MONSTER, 0, 1),
                new MapNode(1, RoomType.MONSTER, 2, 4),
                new MapNode(1, RoomType.ELITE, 4, 5),
                new MapNode(1, RoomType.UNKNOWN, 5, 6)
        );
        act[13] = s13;
        List<MapNode> s14 = List.of(
                new MapNode(1, RoomType.REST, 0, 1),
                new MapNode(1, RoomType.REST, 2, 3),
                new MapNode(1, RoomType.REST, 3, 5),
                new MapNode(1, RoomType.REST, 5, 6)
        );
        act[14] = s14;
        List<MapNode> s15 = List.of(
                new MapNode(1, RoomType.BOSS, 0, 6)
        );
        act[15] = s15;
        return act;
    }
}
