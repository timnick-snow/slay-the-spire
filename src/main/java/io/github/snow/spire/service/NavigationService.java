package io.github.snow.spire.service;

import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.BossManager;
import io.github.snow.spire.items.MapManager;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.items.reward.Reward;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

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
            Optional<RoomNode> roomNodeOpt = runSupport.getRoomById(roomNum);
            if (roomNodeOpt.isEmpty()) {
                return "无效的房号";
            }
            RoomNode roomNode = roomNodeOpt.get();
            String info = "%s房间\t\t类型：%s\t\t可达房间：%d\n".formatted(roomId, roomNode.getRoomType().displayName(), roomNode.getNext().size());
            return info + mapManager.format(roomNode.getNext());
        }
    }

    public String go(int roomId) {
        List<Reward> rewards = runSupport.getRunContext().getRewards();
        if (!rewards.isEmpty()) {
            return "请先处理奖励列表 - reward";
        }
        if (runSupport.getRunContext().getRoomResult() != null) {
            return "请先离开当前房间";
        }

        Optional<RoomNode> roomNodeOpt = runSupport.getRoomById(roomId);
        if (roomNodeOpt.isEmpty()) {
            return "无效的房号";
        }
        boolean enterFlag = runSupport.goRoom(roomNodeOpt.get());
        if (!enterFlag) {
            return "不可达房间";
        }
        return "";
    }

    private FloorRooms[] getCurMap() {
        RunContext runContext = runSupport.getRunContext();
        int act = runContext.getAct();
        return runContext.getMap()[act];
    }
}
