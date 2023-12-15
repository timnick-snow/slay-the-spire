package io.github.snow.spire.beans.pojo;

import io.github.snow.spire.beans.context.FightContext;

/**
 * @author snow
 * @since 2023/12/15
 */
public record RoomFight(FightContext fightContext) implements EnterRoomResult {
}
