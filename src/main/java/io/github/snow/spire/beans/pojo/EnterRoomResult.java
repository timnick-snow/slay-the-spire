package io.github.snow.spire.beans.pojo;

/**
 * @author snow
 * @since 2023/12/15
 */
public sealed interface EnterRoomResult permits RoomFight, RoomFree, RoomChoose {

}
