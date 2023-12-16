package io.github.snow.spire.service;

import io.github.snow.spire.beans.context.FightContext;
import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.FightManager;
import io.github.snow.spire.items.core.FightCard;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;

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
        fightManager.overview(getRoomFight().fightContext());
    }

    public void drawPile() {
        fightManager.drawPile(getRoomFight().fightContext());
    }

    public void discardPile() {
        fightManager.discardPile(getRoomFight().fightContext());
    }

    public void exhaustPile() {
        fightManager.exhaustPile(getRoomFight().fightContext());
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
}
