package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.beans.pojo.RoomAmend;
import io.github.snow.spire.enums.RoomType;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.items.map.WayBranch;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.github.snow.spire.tool.FormatUtil.center;

/**
 * 地图生成
 *
 * @author snow
 * @since 2023/12/4
 */
@Slf4j
@Component
public class MapManager {
    private Random mapRandom;

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

    /**
     * 楼层房间类型
     */
    static final int[][] ROOM_TYPE_ODDS = {
            {1000, 0, 0, 0, 0},
            {600, 350, 50, 0, 0},
            {430, 370, 200, 0, 0},
            {490, 440, 70, 0, 0},
            {570, 340, 90, 0, 0},
            {100, 10, 0, 520, 370},
            {330, 240, 30, 200, 200},
            {350, 210, 50, 220, 170},
            {0, 0, 0, 0, 0},
            {380, 280, 20, 120, 200},
            {390, 270, 30, 190, 120},
            {320, 210, 90, 190, 190},
            {450, 210, 40, 210, 90},
            {705, 125, 70, 100, 0},
            {0, 0, 0, 0, 1000},
    };


    public FloorRooms[][] gen() {
        FloorRooms[][] res = new FloorRooms[3][16];
        for (int i = 0; i < 3; i++) {
            res[i] = genActMap(i, new RoomAmend());
        }
        return res;
    }

    FloorRooms[] genActMap(int act, RoomAmend roomAmend) {
        int[] rooms = rooms();
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
                    // 0-小怪 8-宝箱 其它暂定未知
                    RoomType roomType = switch (i) {
                        case 0 -> RoomType.MONSTER;
                        case 8 -> RoomType.TREASURE;
                        default -> RoomType.UNKNOWN;
                    };
                    roomNode.setRoomType(roomType);
                    res[i].addRoom(roomNode);
                }
                if (i > 0) {
                    connect(res[i - 1], res[i], roomAmend);
                }
            }
        }

        return res;
    }


    private void connect(FloorRooms child, FloorRooms parent, RoomAmend roomAmend) {
        int from = child.getRooms().size();
        int to = parent.getRooms().size();
        log.info("gen map strategy from {} to {}", from, to);
        List<List<Integer>> strategy = WayBranch.strategy(from, to, mapRandom);
        List<RoomNode> parentRooms = parent.getRooms();
        for (int i = 0; i < strategy.size(); i++) {
            List<RoomNode> childRooms = child.getRooms();
            RoomNode c = childRooms.get(i);
            for (Integer pid : strategy.get(i)) {
                c.addParentNode(parentRooms.get(pid));
            }
        }
        // 确定parent的房间类型
        int idx = parent.getStair() % 17 - 1;
        int shop = 0;
        int[] odds = ROOM_TYPE_ODDS[idx];
        for (int i = 0; i < parentRooms.size(); i++) {
            RoomNode roomNode = parentRooms.get(i);
            if (i == parentRooms.size() - 1) {
                // 商店修正
                if (idx == 11 && roomAmend.getShopNum() == 0) {
                    roomNode.setRoomType(RoomType.SHOP);
                    roomAmend.setShopNum(1);
                    break;
                }
                if (idx == 13 && roomAmend.getShopNum() == 1) {
                    roomNode.setRoomType(RoomType.SHOP);
                    roomAmend.setShopNum(2);
                    break;
                }
                // 精英修正
                if (idx == 5 && !roomAmend.isEliteDown()) {
                    roomNode.setRoomType(RoomType.ELITE);
                    roomAmend.setEliteDown(true);
                    break;
                }
                if (idx == 11 && !roomAmend.isEliteUp()) {
                    roomNode.setRoomType(RoomType.ELITE);
                    roomAmend.setEliteUp(true);
                    break;
                }
                // 火堆修正
                if (idx == 7 && !roomAmend.isRestDown()) {
                    roomNode.setRoomType(RoomType.REST);
                    roomAmend.setRestDown(true);
                    break;
                }
                if (idx == 12 && !roomAmend.isRestUp()) {
                    roomNode.setRoomType(RoomType.REST);
                    roomAmend.setRestUp(true);
                    break;
                }
            }

            while (true) {
                int value = mapRandom.nextInt(0, 1000);
                int typeIdx = RandomUtil.randomIndex(odds, value);
                RoomType roomType = switch (typeIdx) {
                    case 0 -> RoomType.MONSTER;
                    case 1 -> RoomType.UNKNOWN;
                    case 2 -> RoomType.SHOP;
                    case 3 -> RoomType.ELITE;
                    case 4 -> RoomType.REST;
                    default -> throw new IllegalStateException("Unexpected value: " + typeIdx);
                };
                // 判断是否合法
                if (roomType == RoomType.SHOP) {
                    if (shop >= 2 || roomAmend.getShopNum() >= 3 || consecutiveSame(roomType, roomNode.getPrev())) {
                        continue;
                    }
                    shop++;
                    roomAmend.setShopNum(roomAmend.getShopNum() + 1);
                }
                if (roomType == RoomType.ELITE) {
                    if (consecutiveSame(roomType, roomNode.getPrev())) {
                        continue;
                    }
                    if (idx == 5) {
                        roomAmend.setEliteDown(true);
                    }
                    if (idx >= 9 && idx <= 11) {
                        roomAmend.setEliteUp(true);
                    }
                }
                if (roomType == RoomType.REST) {
                    if (consecutiveSame(roomType, roomNode.getPrev())) {
                        continue;
                    }
                    if (idx >= 5 && idx <= 7) {
                        roomAmend.setRestDown(true);
                    }
                    if (idx >= 9 && idx <= 12) {
                        roomAmend.setRestUp(true);
                    }
                }

                roomNode.setRoomType(roomType);
                break;
            }
        }
    }

    private boolean consecutiveSame(RoomType roomType, List<RoomNode> prev) {
        return prev.stream().anyMatch(r -> r.getRoomType() == roomType);
    }

    int[] rooms() {
        int[] res = new int[16];
        int x = RandomUtil.randomIndex(FIRST_ROOM_ODDS, mapRandom.nextInt(0, 1000));
        res[0] = x;
        for (int i = 1; i < res.length; i++) {
            res[i] = RandomUtil.randomIndex(ROOM_CHANGE_ODDS[res[i - 1]], mapRandom.nextInt(0, 1000));
        }
        // boss层固定单个房间
        res[res.length - 1] = 1;
        return res;
    }

/*

      \ /
_____  M
 */

    public String mapFormat(FloorRooms[] map, int start, int limit, String boss) {
        if (limit == 0) {
            return "";
        }
        int end = limit < 0 ? map.length : start + limit;
        List<StringBuilder> list = new ArrayList<>();
        String padding = " ".repeat(5);
        for (int i = start; i < end; i++) {
            FloorRooms rooms = map[i];
            StringBuilder roomBuf = new StringBuilder();
            StringBuilder wayBuf = new StringBuilder();
            // boss房间特殊处理
            if (i == map.length - 1) {
                roomBuf.append(center("B O S S - %s".formatted(boss), 45));
                list.add(roomBuf);
                break;
            }
            int stair = rooms.getStair();
            roomBuf.append(stair).append("层");
            roomBuf.append(stair > 9 ? " " : "  ");
            wayBuf.append(padding);

            int flag = 0;
            boolean tripleFlag = false;
            for (RoomNode room : rooms.getRooms()) {
                int nextSize = room.getNext().size();
                if (room.getPrev().size() > 1 || nextSize > 1 || tripleFlag) {
                    // 偏移填充
                    roomBuf.append(padding);
                    wayBuf.append(padding);
                    tripleFlag = false;
                }
                roomBuf.append(center(room.getRoomType().displayName(), 5));
                if (nextSize == 2) {
                    wayBuf.append(center("\\ /", 5));
                } else if (nextSize == 3) {
                    wayBuf.append(center("\\|/", 5));
                    tripleFlag = true;
                } else {
                    if (flag == 1) {
                        wayBuf.append(center("\\", 5));
                        flag = 0;
                    } else if (flag > 0) {
                        wayBuf.append(center("|", 5));
                        flag -= 1;
                    } else {
                        int size = room.getNext().getFirst().getPrev().size();
                        if (size == 1) {
                            wayBuf.append(center("|", 5));
                        } else {
                            wayBuf.append(center("/", 5));
                            flag = size - 1;
                        }
                    }
                }
            }

            list.add(roomBuf);
            list.add(wayBuf);
        }

        StringBuilder buf = new StringBuilder(256);
        for (int i = list.size() - 1; i >= 0; i--) {
            if (i == list.size() - 1 && ((i & 1) == 1)) {
                continue;
            }
            buf.append(list.get(i)).append("\n");
        }
        // 图例
        buf.append("\n");
        buf.append("M - 小怪\t\t? - 不明\t\tS - 商店\n");
        buf.append("E - 精英\t\tR - 火堆\t\tT - 财宝\n");
        return buf.toString();
    }

    public String format(FloorRooms floorRooms) {
        return format(floorRooms.getRooms());
    }

    public String format(List<RoomNode> roomNodes) {
        StringBuilder buf = new StringBuilder();
        for (RoomNode room : roomNodes) {
            buf.append(room.getId()).append("  ").append(room.getRoomType().displayName());
            if (!room.getNext().isEmpty()) {
                buf.append(" -> ");
                if (room.getNext().size() == 1) {
                    buf.append(room.getNext().getFirst().getRoomType().displayName());
                } else {
                    buf.append("(");
                    for (RoomNode nextRoom : room.getNext()) {
                        buf.append(nextRoom.getRoomType().displayName()).append(",");
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

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.mapRandom = source.getRandomManage().getMapRandom();
    }
}
