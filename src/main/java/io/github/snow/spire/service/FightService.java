package io.github.snow.spire.service;

import io.github.snow.spire.beans.pojo.EnterRoomResult;
import io.github.snow.spire.beans.pojo.RoomFight;
import io.github.snow.spire.game.RunSupport;
import io.github.snow.spire.items.FightManager;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.stereotype.Service;

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
        EnterRoomResult roomResult = runSupport.getRunContext().getRoomResult();
        if (roomResult instanceof RoomFight roomFight) {
            fightManager.overview(roomFight.fightContext());
        }
    }

    public void drawPile() {
        EnterRoomResult roomResult = runSupport.getRunContext().getRoomResult();
        if (roomResult instanceof RoomFight roomFight) {
            fightManager.drawPile(roomFight.fightContext());
        }
    }

    public void discardPile() {
        EnterRoomResult roomResult = runSupport.getRunContext().getRoomResult();
        if (roomResult instanceof RoomFight roomFight) {
            fightManager.discardPile(roomFight.fightContext());
        }
    }

    public void exhaustPile() {
        EnterRoomResult roomResult = runSupport.getRunContext().getRoomResult();
        if (roomResult instanceof RoomFight roomFight) {
            fightManager.exhaustPile(roomFight.fightContext());
        }
    }
}
