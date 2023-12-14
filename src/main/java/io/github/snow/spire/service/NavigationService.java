package io.github.snow.spire.service;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.BossManager;
import io.github.snow.spire.items.MapManager;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author snow
 * @since 2023/12/14
 */
@Service
@RequiredArgsConstructor
public class NavigationService {
    private final RunSupport runSupport;
    private final MapManager mapManager;
    private final BossManager bossManager;


    public String map(int start, int limit) {
        int act = runSupport.getRunContext().getAct();
        return mapManager.mapFormat(getCurMap(), start, limit, bossManager.getBoss(act));
    }

    public String way(String roomId) {
        if (ObjectUtils.isEmpty(roomId)) {
            return runSupport.tips();
        } else {
            int roomNum = Convert.toInt(roomId, -1);
            if (roomNum == -1) {
                return "无效的房号";
            }
            int stair = roomNum / 100;
            int act = runSupport.getRunContext().getAct();
            int floorIdx = stair - act * 17 - 1;
            if (floorIdx < 0 || floorIdx > 14) {
                return "无效的房号";
            }

            int idx = roomNum % 100 - 1;
            List<RoomNode> rooms = getCurMap()[floorIdx].getRooms();
            if (idx < 0 || idx > rooms.size() - 1) {
                return "无效的房号";
            }
            return mapManager.format(rooms.get(idx).getNext());
        }
    }

    private FloorRooms[] getCurMap() {
        RunContext runContext = runSupport.getRunContext();
        int act = runContext.getAct();
        return runContext.getMap()[act];
    }
}
