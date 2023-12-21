package io.github.snow.spire.beans.context;

import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.enums.CombatType;
import io.github.snow.spire.game.Deck;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.card.UpgradableCard;
import io.github.snow.spire.items.core.DisplayAble;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.Fighter;
import io.github.snow.spire.items.effect.Effect;
import io.github.snow.spire.items.enemy.Enemy;
import io.github.snow.spire.items.player.*;
import io.github.snow.spire.items.relic.Relic;
import io.github.snow.spire.tool.Convert;
import io.github.snow.spire.tool.FormatUtil;
import io.github.snow.spire.tool.Output;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

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
    private final List<Enemy> enemies;

    // 你的遗物
    private List<Relic> relics;

    // 当前回合数
    private int round = 1;
    private int round2 = 1;

    // 剩余能量
    private int energy;

    // 手牌
    private final List<FightCard> hand;

    // 抽牌堆
    private final Deque<FightCard> drawPile;

    // 弃牌堆
    private final Deque<FightCard> discardPile;

    // 消耗堆
    private final Deque<FightCard> exhaustPile;

    // 待打出区
    private final Deque<FightCard> playZone;

    // 其它。。。
    private RunSupport runSupport;

    // 战斗类型
    private final CombatType combatType;

    // 洗牌随机数
    private Random shuffleRandom;
    // 敌人行动随机数
    private Random enemyRandom;

    private int cid;

    private boolean completed;
    // 效果队列
    private final Deque<Effect<?>> effectDeque;
    // 回合标识
    private boolean playerRound;

    public FightContext(CombatType combatType) {
        this.combatType = combatType;
        enemies = new ArrayList<>();

        hand = new ArrayList<>();
        drawPile = new ArrayDeque<>();
        discardPile = new ArrayDeque<>();
        exhaustPile = new ArrayDeque<>();
        playZone = new ArrayDeque<>();
        effectDeque = new ArrayDeque<>();
        playerRound = true;
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
                .map(card -> new FightCard(card.copy(""), player, String.format("d%02d", ++cid)))
                .toList();
        this.drawPile.addAll(initCards);
        this.shuffleRandom = runSupport.getRunContext().getRandomManage().getFightRandom1();
        this.enemyRandom = runSupport.getRunContext().getRandomManage().getFightRandom2();
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        Output.println("洗牌！");

        List<FightCard> list = new ArrayList<>();
        list.addAll(discardPile);
        list.addAll(drawPile);
        discardPile.clear();
        drawPile.clear();
        // 打乱顺序
        Collections.shuffle(list, shuffleRandom);

        for (FightCard card : list) {
            card.position(CardPosition.DRAW_PILE);
            drawPile.add(card);
        }
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
                Output.println("手牌数已满！");
                break;
            }
            if (drawPile.isEmpty()) {
                if (!discardPile.isEmpty()) {
                    shuffle();
                } else {
                    Output.println("无牌可抽了！");
                    break;
                }
            }
            FightCard fightCard = drawPile.removeFirst();
            fightCard.position(CardPosition.HAND);
            res.add(fightCard);
            hand.add(fightCard);
            num--;
        }
        Output.println(STR."你抽取了 \{res.size()} 张牌");
        return res;
    }

    /**
     * 敌人增加
     */
    public void addEnemy(Enemy enemy) {
        Output.println(STR."敌人 【\{enemy.displayName()}】 出现了");
        this.enemies.add(enemy);
    }


    public void addEnemies(List<Enemy> enemies) {
        Output.println(STR."敌人 \{
                enemies.stream()
                        .map(DisplayAble::displayName)
                        .map(FormatUtil::kw)
                        .collect(Collectors.joining(" "))
                } 出现了");
        this.enemies.addAll(enemies);
    }

    /**
     * 回合增加
     */
    public void roundAdd() {
        ++round;
    }

    public void round2Add() {
        ++round2;
    }

    public void setEnergy(int energy) {
        Output.println(STR."你的能量变为：\{energy}");
        this.energy = energy;
    }

    public void addEnergy(int add) {
        if (add == 0) {
            return;
        }
        if (add < 0) {
            add = Math.max(add, -energy);
        }
        Output.println(STR."你的能量\{add < 0 ? "减少了" : "增加了"} \{add} E");
        this.energy += add;
    }

    public Optional<FightCard> findCardById(String id) {
        if (ObjectUtils.isEmpty(id)) {
            return Optional.empty();
        }
        if (id.length() == 1) {
            int idx = Convert.toInt(id, -1);
            if (idx < 0 || idx >= hand.size()) {
                return Optional.empty();
            }
            return Optional.of(hand.get(idx));
        }
        return drawPile.stream().filter(card -> card.id().equals(id)).findFirst()
                .or(() -> discardPile.stream().filter(card -> card.id().equals(id)).findFirst())
                .or(() -> exhaustPile.stream().filter(card -> card.id().equals(id)).findFirst())
                .or(() -> playZone.stream().filter(card -> card.id().equals(id)).findFirst());
    }

    public void consumeEnergy(int cost) {
        this.energy = Math.max(0, energy - cost);
        Output.println(STR."你消耗了 \{cost} 能量，剩余能量 \{energy}");
    }

    public void moveCard(FightCard card, CardPosition dest) {
        CardPosition src = card.position();
        if (src == dest) {
            return;
        }
        switch (src) {
            case HAND -> hand.remove(card);
            case DRAW_PILE -> drawPile.remove(card);
            case DISCARD_PILE -> discardPile.remove(card);
            case EXHAUST_PILE -> exhaustPile.remove(card);
            case PLAY_ZONE -> playZone.remove(card);
        }
        card.position(dest);
        switch (dest) {
            case HAND -> hand.add(card);
            case DRAW_PILE -> drawPile.add(card);
            case DISCARD_PILE -> discardPile.add(card);
            case EXHAUST_PILE -> exhaustPile.add(card);
            case PLAY_ZONE -> playZone.add(card);
        }
    }

    public Optional<Fighter> findFighterById(String id) {
        if (player.number().equals(id)) {
            return Optional.ofNullable(player);
        }
        return enemies.stream()
                .filter(enemy -> enemy.number().equals(id))
                .map(enemy -> (Fighter) enemy)
                .findFirst();
    }

    public void addEffectTail(Effect<?> effect) {
        this.effectDeque.addLast(effect);
    }

    public void addEffectTail(List<Effect<?>> effects) {
        this.effectDeque.addAll(effects);
    }

    public void addEffectHead(Effect<?> effect) {
        this.effectDeque.addFirst(effect);
    }

    public void addEffectHead(List<Effect<?>> effects) {
        for (int i = effects.size() - 1; i >= 0; i--) {
            this.effectDeque.addFirst(effects.get(i));
        }
    }

    public void runEffect() {
        while (!effectDeque.isEmpty()) {
            Effect<?> effect = effectDeque.pollFirst();
            effect.work(this);
            if (player.isDie()) {
                Output.println("\n你死了！\n");
                this.completed = true;
                runSupport.gameOver();
                break;
            }
            enemies.removeIf(Fighter::isDie);
            if (enemies.isEmpty()) {
                fightEnd();
                break;
            }
        }
    }

    public String nextCid() {
        return String.format("d%02d", ++cid);
    }

    private void fightEnd() {
        Output.println("\n战斗胜利！\n");
        this.completed = true;
        // lifecycle 战斗结束
        this.player.onFightEnd(this);
        // 战斗奖励
        Output.println();
        runSupport.fightVictory(this);
    }

    public boolean isHandFull() {
        return hand.size() >= 10;
    }

    public void addFightCard(FightCard fightCard, CardPosition dest) {
        switch (dest) {
            case HAND -> {
                if (isHandFull()) {
                    Output.printf("手牌数已满！\n");
                    drawPile.addLast(fightCard);
                } else {
                    hand.add(fightCard);
                }
            }
            case DRAW_PILE -> drawPile.addLast(fightCard);
            case DISCARD_PILE -> discardPile.addLast(fightCard);
            default -> throw new IllegalArgumentException(STR."Add fight card not support dest: \{dest}");
        }
    }

    public void upgradeCards(List<FightCard> targets) {
        targets.forEach(card -> {
            if (card instanceof UpgradableCard uc && uc.isUpgradable()) {
                uc.upgrade();
            }
        });
    }
}
