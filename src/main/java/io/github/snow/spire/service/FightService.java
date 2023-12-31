package io.github.snow.spire.service;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.PlayRule;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.enums.CardPosition;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.FightManager;
import io.github.snow.spire.items.core.FightCard;
import io.github.snow.spire.items.core.Fighter;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

/**
 * @author snow
 * @since 2023/12/15
 */
@Service
@RequiredArgsConstructor
public class FightService {

    private final RunSupport runSupport;
    private final FightManager fightManager;

    public Availability availability() {
        EnterRoomResult roomResult = runSupport.getRunContext().getRoomResult();
        if (roomResult instanceof RoomFight roomFight && !roomFight.fightContext().isCompleted()) {
            return Availability.available();
        }
        return Availability.unavailable("仅战斗中可用！");
    }

    public void overview() {
        fightManager.overview();
    }

    public void drawPile() {
        fightManager.drawPile();
    }

    public void discardPile() {
        fightManager.discardPile();
    }

    public void exhaustPile() {
        fightManager.exhaustPile();
    }

    public String card(String id) {
        FightContext ctx = getRoomFight().fightContext();
        Optional<FightCard> opt = ctx.findCardById(id);
        if (opt.isEmpty()) {
            return "未找到卡牌：" + id;
        }
        return fightManager.cardFormat(opt.get());
    }

    private RoomFight getRoomFight() {
        return (RoomFight) runSupport.getRunContext().getRoomResult();
    }

    public String playCard(String id, String target) {
        FightContext ctx = getRoomFight().fightContext();
        Optional<FightCard> cardOpt = ctx.findCardById(id);
        if (cardOpt.isEmpty()) {
            return "未找到卡牌：" + id;
        }
        FightCard fightCard = cardOpt.get();
        if (fightCard.position() != CardPosition.HAND) {
            return "这张卡不在你的手牌中！";
        }
        PlayRule playRule = new PlayRule();

        if (!ObjectUtils.isEmpty(target)) {
            Optional<Fighter> fighterOpt = ctx.findFighterById(target);
            if (fighterOpt.isEmpty()) {
                return "未找到目标：" + target;
            }
            playRule.setMaster(fighterOpt.get());
        }

        fightManager.playCard(fightCard, playRule);
        return null;
    }

    public String powerInfo(String id) {
        FightContext ctx = getRoomFight().fightContext();
        Fighter fighter;
        if (ObjectUtils.isEmpty(id)) {
            fighter = ctx.getPlayer();
        } else {
            Optional<Fighter> fighterOpt = ctx.findFighterById(id);
            if (fighterOpt.isEmpty()) {
                return "未找到目标：" + id;
            } else {
                fighter = fighterOpt.get();
            }
        }
        return fightManager.powerInfo(fighter);
    }

    public String hand() {
        return fightManager.handFormat();
    }

    public void endRound() {
        fightManager.endPlayerRound();
    }
}
