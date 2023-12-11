package io.github.snow.spire.beans.context;

import org.springframework.context.ApplicationEvent;

/**
 * @author snow
 * @since 2023/12/11
 */
public class GameStartEvent extends ApplicationEvent {

    public GameStartEvent(Object source) {
        super(source);
    }
}
