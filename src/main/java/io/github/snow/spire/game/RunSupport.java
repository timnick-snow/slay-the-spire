package io.github.snow.spire.game;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.context.GameStartEvent;
import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.RoomChoose;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.beans.pojo.RoomFree;
import io.github.snow.spire.enums.*;
import io.github.snow.spire.items.*;
import io.github.snow.spire.items.bless.Bless;
import io.github.snow.spire.items.bless.ExchangeBossRelic;
import io.github.snow.spire.items.card.Card;
import io.github.snow.spire.items.map.FloorRooms;
import io.github.snow.spire.items.map.RoomNode;
import io.github.snow.spire.items.potion.Potion;
import io.github.snow.spire.items.relic.Relic;
import io.github.snow.spire.items.reward.CardReward;
import io.github.snow.spire.items.reward.PotionReward;
import io.github.snow.spire.items.reward.Reward;
import io.github.snow.spire.service.FlowService;
import io.github.snow.spire.temp.GameContext;
import io.github.snow.spire.temp.RunContext;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    private final PotionManager potionManager;
    private final RewardManager rewardManager;
    private final CardManager cardManager;
    private final MapManager mapManager;
    private final RoomManager roomManager;
    private final FightManager fightManager;
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
        // 发布事件
        applicationContext.publishEvent(new GameStartEvent(this));
        // 生成地图
        runContext.setMap(mapManager.gen());
    }

    public String roleInfo() {
        String res = "hp: %d/%d  |  金币: %d  |  %s  |  %s  | %s\n";
        return res.formatted(runContext.getHp(), runContext.getMaxHp(), runContext.getGold(),
                runContext.getPotionGroup().formatCount(), runContext.getRelicGroup().formatCount(), runContext.getDeck().formatCount());
    }

    public String position() {
        return "幕: %d\t层: %d\t房间: %d".formatted(runContext.getAct() + 1, runContext.getStair() + 1, runContext.getRoomId());
    }

    public String nextItemId(String prefix) {
        int id = runContext.incrementItemId();
        return "%s%02d".formatted(prefix, id);
    }

    public List<String> nextItemIds(String prefix, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(nextItemId(prefix));
        }
        return res;
    }


    public void goHint() {
        // todo 能否前进？
        // tips
        String tips = roleInfo() + "\n";
        FloorRooms floorRooms = runContext.getNextFloor();
        tips += "前方有" + floorRooms.getRooms().size() + "个房间，请选择一个进入\n";
        tips += mapManager.format(floorRooms);
        runContext.setLastTips(tips);
    }

    public boolean takeBless() {
        Bless bless = flowService.blessSelect(genBless(), runContext);
        return bless.run(runContext, this);
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
        writeAndFlush("你的最大生命值%s了：%d -> %d".formatted(action, maxHp, runContext.getMaxHp()));

        // 处理hp
        int hp = runContext.getHp();
        if (addValue > 0) {
            runContext.setHp(hp + addValue);
            writeAndFlush("你的生命值增加了：%d -> %d".formatted(hp, runContext.getHp()));
        } else if (hp > runContext.getMaxHp()) {
            runContext.setHp(runContext.getMaxHp());
            writeAndFlush("你的生命值减少了：%d -> %d".formatted(hp, runContext.getHp()));
        }
        writeAndFlush("");
    }

    public void addHp(int addValue) {
        if (addValue == 0) {
            return;
        }
        String action = addValue > 0 ? "增加" : "减少";
        int hp = runContext.getHp();
        runContext.setHp(hp + addValue);
        writeAndFlush("你的生命值%s了，hp: %d => %d\n".formatted(action, hp, runContext.getHp()));
    }

    public void addGold(int addValue) {
        if (addValue == 0) {
            return;
        }
        String action = addValue > 0 ? "增加" : "减少";
        int gold = runContext.getGold();
        runContext.setGold(gold + addValue);
        writeAndFlush("你的金币%s了：%d -> %d".formatted(action, gold, runContext.getGold()));
    }

    public void addRelic(Relic relic) {
        runContext.getRelicGroup().addRelic(relic);
        writeAndFlush("你获得了【%s】！".formatted(relic.name()));
    }

    public void addRandomRelic(RelicRarity rarity) {
        Relic relic = relicManager.getRelic(rarity);
        addRelic(relic);
    }

    public void lossRelic(Predicate<Relic> predicate) {
        List<Relic> loss = runContext.getRelicGroup().lossRelic(predicate);
        if (!loss.isEmpty()) {
            writeAndFlush("你失去了【%s】！".formatted(loss.getFirst().name()));
        }
    }

    public void exchangeBossRelic() {
        lossRelic(relic -> relic.rarity() == RelicRarity.STARTER);
        addRandomRelic(RelicRarity.BOSS);
        writeAndFlush("");
    }

    public void addAndShowRewards(List<Reward> rewards) {
        runContext.getRewards().addAll(rewards);
        writeAndFlush(rewardManager.format(rewards, false));
    }

    /**
     * 药水奖励
     */
    public void rewardPotion(int num) {
        List<Potion> potionList = potionManager.getPotion(num);
        List<Reward> list = potionList.stream()
                .map(PotionReward::new)
                .map(pr -> (Reward) pr)
                .toList();
        addAndShowRewards(list);
    }


    public boolean addPotion(Potion potion) {
        boolean res = runContext.getPotionGroup().addPotion(potion);
        if (res) {
            writeAndFlush("你获得了【%s】！".formatted(potion.getName()));
        } else {
            writeAndFlush("药水栏不足！");
        }
        return res;
    }


    public void clearRewards() {
        runContext.setRewards(Collections.emptyList());
    }

    public void addCard(Card card) {
        runContext.getDeck().add(card);
        writeAndFlush("你获得了卡牌【%s】！".formatted(card.displayName()));
    }

    public void addRandomCard(Predicate<Card> filter) {
        Card card = cardManager.getRandom(filter);
        addCard(card);
    }

    public boolean rewardChooseCard(Predicate<Card> filter) {
        List<Card> cards = cardManager.getRandoms(filter);
        CardReward reward = new CardReward(cards);
        boolean taken = reward.take(this);
        if (taken) {
            return true;
        }
        addAndShowRewards(Collections.singletonList(reward));
        return false;
    }

    public boolean rewardChooseCard() {
        Predicate<Card> filter = card -> card.color() == runContext.getCharacter().color();
        List<Card> cards = cardManager.rewardCard(filter, CombatType.NORMAL);
        CardReward reward = new CardReward(cards);
        boolean taken = reward.take(this);
        if (taken) {
            return true;
        }
        addAndShowRewards(Collections.singletonList(reward));
        return false;
    }

    public boolean chooseCard(List<Card> cards) {
        Optional<Card> card = flowService.chooseCard(cards);
        if (card.isPresent()) {
            addCard(card.get());
            return true;
        }
        return false;
    }


    public void upgradeCard() {
        Deck deck = runContext.getDeck();
        flowService.upgradeCard(deck);
    }

    public void transformCard(int n) {
        List<Card> removed = flowService.transformCard(runContext.getDeck(), n);
        List<Card> adds = cardManager.transformCard(removed);
        for (Card card : adds) {
            addCard(card);
        }
    }

    public Optional<RoomNode> getRoomById(int roomId) {
        int stair = roomId / 100;
        int act = runContext.getAct();
        int floorIdx = stair - act * 17 - 1;
        if (floorIdx < 0 || floorIdx > 14) {
            return Optional.empty();
        }
        int idx = roomId % 100 - 1;
        List<RoomNode> rooms = runContext.getMap()[act][floorIdx].getRooms();
        if (idx < 0 || idx > rooms.size() - 1) {
            return Optional.empty();
        }
        return Optional.ofNullable(rooms.get(idx));
    }

    public boolean goRoom(RoomNode roomNode) {
        boolean res;
        if (runContext.getRoomId() == -1) {
            res = roomNode.getAct() == runContext.getAct() && roomNode.getStairId() == 0;
        } else {
            RoomNode curRoom = runContext.getCurRoom();
            res = curRoom.getPids().contains(roomNode.getId());
        }

        if (res) {
            EnterRoomResult roomResult = roomManager.enter(roomNode, runContext);
            runContext.setStair(roomNode.getStair());
            runContext.setRoomId(roomNode.getId());

            runContext.setRoomResult(roomResult);
            switch (roomResult) {
                case RoomFight roomFight -> {
                    roomFight.fightContext().init(this);
                    fightManager.startFight(roomFight.fightContext());
                }
                case RoomChoose roomChoose -> {
                    // todo
                }
                case RoomFree roomFree -> {
                    // todo
                }
            }
        }
        return res;
    }

    // 战斗胜利
    public void fightVictory(FightContext fightContext) {
        List<Reward> list = rewardManager.fightReward(fightContext.getCombatType());
        addAndShowRewards(list);
    }

    public void gameOver() {
        this.runContext = null;
        gameContext.clearRun();
        gameContext.setMainPage(MainPage.CATALOG);
    }

    public boolean canLeaveRoom() {
        EnterRoomResult roomResult = runContext.getRoomResult();
        return switch (roomResult) {
            case RoomChoose roomChoose -> false;
            case RoomFight roomFight -> roomFight.fightContext().isCompleted();
            case RoomFree roomFree -> true;
        };
    }

    public void leaveRoom() {
        boolean can = canLeaveRoom();
        if (!can) {
            writeAndFlush("你还不能离开房间！");
            return;
        }
        runContext.setRoomResult(null);
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

    private void writeAndFlush(String content) {
        terminal.writer().println(content);
        terminal.flush();
    }

    private void write(String content) {
        terminal.writer().println(content);
    }

    private void flush() {
        terminal.flush();
    }
}
