package io.github.snow.spire.beans.context;

import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.game.Deck;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.*;
import io.github.snow.spire.items.relic.Relic;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * 战斗上下文
 *
 * @author snow
 * @since 2023/12/14
 */
@Getter
@Setter
public class FightContext {
    // 你
    private Player player;

    // 敌人
    private List<Enemy> enemies;

    // 你的遗物
    private List<Relic> relics;

    // 当前回合数
    private int round;

    // 剩余能量
    private int energy;

    // 手牌
    private List<FightCard> hand;

    // 抽牌堆
    private Deque<FightCard> drawPile;

    // 弃牌堆
    private Deque<FightCard> discardPile;

    // 消耗堆
    private Deque<FightCard> exhaustPile;

    // 待打出区
    private Deque<FightCard> playZone;

    // 其它。。。
    private RunSupport runSupport;
    private CombatType combatType;
    private Random shuffleRandom;

    private int cid;

    private boolean completed;

    public FightContext() {
        enemies = new ArrayList<>();

        hand = new ArrayList<>();
        drawPile = new ArrayDeque<>();
        discardPile = new ArrayDeque<>();
        exhaustPile = new ArrayDeque<>();
        playZone = new ArrayDeque<>();
    }

    public void init(RunSupport runSupport) {
        this.runSupport = runSupport;
        this.player = switch (runSupport.getRunContext().getCharacter()) {
            case IRONCLAD -> new Ironclad("s0");
            case SILENT -> new Silent("s0");
            case DEFECT -> new Defect("s0");
            case WATCHER -> new Watcher("s0");
        };
        this.relics = runSupport.getRunContext().getRelicGroup().getRelics();
        // 初始化抽牌堆
        Deck deck = runSupport.getRunContext().getDeck();
        List<FightCard> initCards = deck.getCards().stream()
                .map(card -> card.copy(String.format("d%02d", ++cid)))
                .map(card -> new FightCard(card, player))
                .toList();
        this.drawPile.addAll(initCards);
        this.shuffleRandom = runSupport.getRunContext().getRandomManage().getFightRandom1();
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        System.out.println("洗牌！");

        List<FightCard> list = new ArrayList<>();
        list.addAll(discardPile);
        list.addAll(drawPile);
        discardPile.clear();
        drawPile.clear();

        Collections.shuffle(list, shuffleRandom);
        drawPile.addAll(list);
    }

    /*
     * 1. 一张一张抽
     * 2. 手牌满了停止抽牌
     * 3. 抽牌堆为空，且弃牌堆不为空时，洗牌后继续抽
     */

    /**
     * 抽牌
     */
    public List<FightCard> draw(int num) {
        if (num <= 0) {
            return Collections.emptyList();
        }
        List<FightCard> res = new ArrayList<>();
        while (num > 0) {
            if (hand.size() >= 10) {
                System.out.println("手牌数已满！");
                break;
            }
            if (drawPile.isEmpty()) {
                if (!discardPile.isEmpty()) {
                    shuffle();
                } else {
                    System.out.println("无牌可抽了！");
                    break;
                }
            }
            FightCard fightCard = drawPile.pollFirst();
            res.add(fightCard);
            hand.add(fightCard);
            num--;
        }
        System.out.printf("你抽取了 %d 张牌\n", res.size());
        return res;
    }

    /**
     * 敌人增加
     */
    public void addEnemy(Enemy enemy) {
        System.out.printf("敌人 【%s】 出现了\n", enemy.displayName());
        this.enemies.add(enemy);
    }

    /**
     * 回合增加
     */
    public int roundAdd() {
        return ++round;
    }

    public void setEnergy(int energy) {
        System.out.printf("你的能量变为：%d\n", energy);
        this.energy = energy;
    }
}
