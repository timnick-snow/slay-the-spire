package io.github.snow.spire.items;

import io.github.snow.spire.beans.context.ActStartEvent;
import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.enums.RoomType;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.enemy.monster.Cultist;
import io.github.snow.spire.items.enemy.monster.GreenLouse;
import io.github.snow.spire.items.enemy.monster.JawWorm;
import io.github.snow.spire.items.enemy.monster.RedLouse;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.temp.RunContext;
import io.github.snow.spire.tool.Output;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
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

    /**
     * 弱怪池
     */
    private List<List<Enemy>> punyEnemies = new ArrayList<>();
    private int fightCount;

    /*
    战斗(普通/精英/BOSS) -> 战斗上下文，进入战斗
    商店/休息处/宝箱 -> 命令自由行动 自由离开
    事件 -> 强制选择
     */

    /**
     * 进入房间
     */
    public EnterRoomResult enter(RoomNode roomNode, RunContext runContext) {
        Output.printf(STR."你进入了 \{roomNode.getId()} 房间。\n");
        if (roomNode.getRoomType() == RoomType.MONSTER) {
            Output.println("【触发普通战斗！】");
            FightContext ctx = new FightContext(CombatType.NORMAL);
            // todo copy enemy
            ctx.addEnemies(punyEnemies.get(fightCount++));
            return new RoomFight(ctx);
        }
        return null;
    }

    @EventListener(ActStartEvent.class)
    public void onActStart(ActStartEvent event) {
        RunContext runContext = ((RunSupport) event.getSource()).getRunContext();
        // 清空旧数据
        punyEnemies.clear();
        fightCount = 0;
        // 弱怪池
        int act = runContext.getAct();
        int difficulty = runContext.getDifficulty();
        if (act == 0) {
            punyEnemies.add(List.of(new RedLouse("e1", difficulty), new GreenLouse("e2", difficulty)));
            punyEnemies.add(List.of(new JawWorm("e1", difficulty)));
            punyEnemies.add(List.of(new Cultist("e1", difficulty)));
        }
        // todo 临时取消打乱
//        Collections.shuffle(punyEnemies);
    }

    @EventListener(GameStartEvent.class)
    public void onGameStart(GameStartEvent event) {
        RunContext runContext = ((RunSupport) event.getSource()).getRunContext();
        this.roomRandom1 = runContext.getRandomManage().getRoomRandom1();
        this.roomRandom2 = runContext.getRandomManage().getRoomRandom2();
        this.eventRandom = runContext.getRandomManage().getEventRandom();
    }
}
