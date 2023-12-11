package io.github.snow.spire.game;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.items.BlessManager;
import io.github.snow.spire.items.RelicManager;
import io.github.snow.spire.items.bless.Bless;
import io.github.snow.spire.items.bless.ExchangeBossRelic;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.MapHandler;
import io.github.snow.spire.temp.GameContext;
import io.github.snow.spire.temp.RunContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author snow
 * @since 2023/12/6
 */
@Component
@RequiredArgsConstructor
public class RunSupport {

    private final GameContext gameContext;
    private final BlessManager blessManager;
    private final RelicManager relicManager;
    private final ApplicationContext applicationContext;

    @Getter
    private RunContext runContext;

    public boolean exist() {
        return gameContext.isRunning();
    }

    public String brief() {
        return runContext.brief();
    }

    public String tips() {
        return runContext.getLastTips();
    }

    /**
     * 生成一个游戏轮回
     */
    public void startRun(Characters role, int level) {
        this.runContext = gameContext.genRun(role, level);
        gameContext.setMainPage(MainPage.GAMING);
        applicationContext.publishEvent(new GameStartEvent(runContext));
    }

    public String roleInfo() {
        String res = "hp: %d/%d  |  金币: %d  |  %s  |  %s  | %s\n";
        return res.formatted(runContext.getHp(), runContext.getMaxHp(), runContext.getGold(),
                runContext.getPotionGroup().formatCount(), runContext.getRelicGroup().formatCount(), runContext.getDeck().formatCount());
    }

    public String position() {
        return "幕: %d\t层: %d\t房间: %d".formatted(runContext.getAct(), runContext.getStair(), runContext.getRoomId());
    }

    public String nextItemId(String prefix) {
        int id = runContext.incrementItemId();
        return "%s%02d".formatted(prefix, id);
    }

    public List<Bless> genBless() {
        Random eventRandom = runContext.getRandomManage().getEventRandom();
        ArrayList<Bless> list = new ArrayList<>();
        // 前2个祝福
        list.add(blessManager.randomBless(BlessLevel.CARD_RELATED, eventRandom.nextInt(0, 1000)));
        list.add(blessManager.randomBless(BlessLevel.NON_CARD_RELATED, eventRandom.nextInt(0, 1000)));
        // 代价+更好的祝福
        int a = eventRandom.nextInt(0, 1000);
        int b = eventRandom.nextInt(0, 1000);
        int c = eventRandom.nextInt(0, 1000);
        list.add(blessManager.complexBless(a, b, c));
        // 换4
        list.add(new ExchangeBossRelic());
        return list;
    }

    public void goHint() {
        // tips
        String tips = roleInfo() + "\n";
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += MapHandler.format(floorRooms);
        runContext.setLastTips(tips);
    }
}
