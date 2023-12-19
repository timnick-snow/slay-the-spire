package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.enums.RoomType;
import io.github.snow.spire.items.enemy.Cultist;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Output;
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

    /*
    战斗(普通/精英/BOSS) -> 战斗上下文，进入战斗
    商店/休息处/宝箱 -> 命令自由行动 自由离开
    事件 -> 强制选择
     */

    /**
     * 进入房间
     */
    public EnterRoomResult enter(RoomNode roomNode, RunContext runContext) {
        Output.printf("你进入了 %d 房间。\n", roomNode.getId());
        if (roomNode.getRoomType() == RoomType.MONSTER) {
            Output.println("【触发普通战斗！】");
            FightContext ctx = new FightContext();
            ctx.addEnemy(new Cultist("e1", runContext.getDifficulty()));
            ctx.setCombatType(CombatType.NORMAL);
            return new RoomFight(ctx);
        }
        return null;
    }
}
