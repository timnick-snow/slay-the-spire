package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.RoomType;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.temp.RunContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author snow
 * @since 2023/12/14
 */
@Component
public class RoomManager {

    /**
     * 房间随机数 - 小怪
     */
    private Random roomRandom1;

    /**
     * 房间随机数 - 精英
     */
    private Random roomRandom2;

    /**
     * 事件随机数 - 随机事件
     */
    private Random eventRandom;


    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext source = (RunContext) event.getSource();
        this.roomRandom1 = source.getRandomManage().getRoomRandom1();
        this.roomRandom2 = source.getRandomManage().getRoomRandom2();
        this.eventRandom = source.getRandomManage().getEventRandom();
    }

    public Object enter(RoomNode roomNode) {
        // 触发普通战斗 触发事件 进入商店，尽情购物吧
        // 触发精英战斗 进入休息处 你找到了一个大宝箱
        // BOSS战斗
        if (roomNode.getRoomType()== RoomType.MONSTER) {
            System.out.println("【触发普通战斗！】");
        }
        return null;
    }
}
