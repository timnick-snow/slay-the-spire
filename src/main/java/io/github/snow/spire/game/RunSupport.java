package io.github.snow.spire.game;

import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.enums.BlessLevel;
import io.github.snow.spire.enums.Characters;
import io.github.snow.spire.enums.MainPage;
import io.github.snow.spire.enums.RelicRarity;
import io.github.snow.spire.items.BlessManager;
import io.github.snow.spire.items.RelicManager;
import io.github.snow.spire.items.bless.Bless;
import io.github.snow.spire.items.bless.ExchangeBossRelic;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.MapHandler;
import io.github.snow.spire.items.relic.Relic;
import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.GameContext;
import io.github.snow.spire.temp.RunContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
    private final FlowService flowService;
    private final Terminal terminal;

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


    public void goHint() {
        // tips
        String tips = roleInfo() + "\n";
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += MapHandler.format(floorRooms);
        runContext.setLastTips(tips);
    }

    public void takeBless() {
        Bless bless = flowService.blessSelect(genBless(), runContext);
        bless.run(runContext, this);
    }

    public void removeCard() {
        flowService.removeCard(runContext.getDeck());
    }

    public void addMaxHp(int addValue) {
        if (addValue == 0) {
            return;
        }
        String action = addValue > 0 ? "增加" : "减少";
        int maxHp = runContext.getMaxHp();
        runContext.setMaxHp(maxHp + addValue);
        write("你的最大生命值%s了：%d -> %d".formatted(action, maxHp, runContext.getMaxHp()));

        // 处理hp
        int hp = runContext.getHp();
        if (addValue > 0) {
            runContext.setHp(hp + addValue);
            write("你的生命值增加了：%d -> %d".formatted(hp, runContext.getHp()));
        } else if (hp > runContext.getMaxHp()) {
            runContext.setHp(runContext.getMaxHp());
            write("你的生命值减少了：%d -> %d".formatted(hp, runContext.getHp()));
        }
    }

    public void addHp(int addValue) {
        if (addValue == 0) {
            return;
        }
        String action = addValue > 0 ? "增加" : "减少";
        int hp = runContext.getHp();
        runContext.setHp(hp + addValue);
        write("你的生命值%s了，hp: %d => %d".formatted(action, hp, runContext.getHp()));
    }

    public void addGold(int addValue) {
        if (addValue == 0) {
            return;
        }
        String action = addValue > 0 ? "增加" : "减少";
        int gold = runContext.getGold();
        runContext.setGold(gold + addValue);
        write("你的金币%s了：%d -> %d".formatted(action, gold, runContext.getGold()));
    }

    public void addRelic(Relic relic) {
        runContext.getRelicGroup().addRelic(relic);
        write("你获得了【%s】！".formatted(relic.name()));
    }

    public void addRandomRelic(RelicRarity rarity) {
        Relic relic = relicManager.getRelic(rarity);
        addRelic(relic);
    }

    public void lossRelic(Predicate<Relic> predicate) {
        List<Relic> loss = runContext.getRelicGroup().lossRelic(predicate);
        if (!loss.isEmpty()) {
            write("你失去了【%s】！".formatted(loss.getFirst().name()));
        }
    }

    public void exchangeBossRelic() {
        lossRelic(relic -> relic.rarity() == RelicRarity.STARTER);
        addRandomRelic(RelicRarity.BOSS);
    }

    private List<Bless> genBless() {
        ArrayList<Bless> list = new ArrayList<>();
        // 前2个祝福
        list.add(blessManager.randomBless(BlessLevel.CARD_RELATED));
        list.add(blessManager.randomBless(BlessLevel.NON_CARD_RELATED));
        // 代价+更好的祝福
        list.add(blessManager.complexBless());
        // 换4
        list.add(new ExchangeBossRelic());
        return list;
    }

    private void write(String content) {
        terminal.writer().println(content);
        terminal.flush();
    }
}
