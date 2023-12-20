package io.github.snow.spire.beans.context;

import org.springframework.context.ApplicationEvent;

/**
 * @author snow
 * @since 2023/12/11
 */
public class ActStartEvent extends ApplicationEvent {

    public ActStartEvent(Object source) {
        super(source);
    }
}
